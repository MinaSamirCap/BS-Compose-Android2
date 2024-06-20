package com.sample.compose_bs_android2.mine.pdf

import android.content.Context
import com.itextpdf.io.image.ImageDataFactory
import com.itextpdf.kernel.colors.Color
import com.itextpdf.kernel.colors.DeviceRgb
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfPage
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.action.PdfAction
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine
import com.itextpdf.layout.Document
import com.itextpdf.layout.Style
import com.itextpdf.layout.borders.SolidBorder
import com.itextpdf.layout.element.Cell
import com.itextpdf.layout.element.Image
import com.itextpdf.layout.element.LineSeparator
import com.itextpdf.layout.element.Link
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.HorizontalAlignment
import com.itextpdf.layout.properties.Leading
import com.itextpdf.layout.properties.Property
import com.itextpdf.layout.properties.TextAlignment
import com.itextpdf.layout.properties.VerticalAlignment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.OutputStream
import java.math.RoundingMode
import java.net.URL

class PdfDocumentGenerator(
    private val context: Context,
    private val outputStream: OutputStream
) {

    suspend fun generateInvoicePdf(invoice: Invoice) {
        withContext(Dispatchers.IO) {
            //val outputFile = File(context.filesDir, "invoice.pdf")
            val pdfWriter = PdfWriter(outputStream)
            val pdfDocument = PdfDocument(pdfWriter)
            val document = Document(pdfDocument, PageSize(650f, 700f)).apply {

                // margin for the page.
                setMargins(50f, 13f, 13f, 13f)

                // space between two elements.
                setProperty(
                    Property.LEADING,
                    Leading(Leading.MULTIPLIED, 1f)
                )

                // space between words in the document
                setWordSpacing(0f)
            }

            val page = pdfDocument.addNewPage()

            createTopSection(document, page, invoice)
            createPeopleSection(document, page, invoice)
            createProductsSection(document, page, invoice)
            createSignatureSection(document, page, invoice)

            document.close()

        }
    }

    private fun createSignatureSection(document: Document, page: PdfPage, invoice: Invoice) {

        val signatureTable = Table(2, true).apply {
            setMarginLeft(15f)
            setMarginRight(15f)
        }

        invoice.signatureUrl?.let {
            val imageData = ImageDataFactory.create(URL(it))
            val image = Image(imageData)
            image.setTextAlignment(TextAlignment.LEFT)
                .setWidth(50f)
                .setHeight(50f)

            val signatureCell = Cell().add(image).setPaddingTop(10f).setBorder(null)
            signatureTable.addCell(signatureCell)
        }

        val totalPrice = createBoldTextParagraph("$${calculateTotalPrice(invoice)}")
            .setTextAlignment(TextAlignment.RIGHT)
            .setBold()

        val totalColumnSpan = if (invoice.signatureUrl != null) 1 else 2
        val totalPriceCell = Cell(1, totalColumnSpan).add(totalPrice)
            .setPaddingTop(10f)
            .setBorder(null)
            .setVerticalAlignment(VerticalAlignment.MIDDLE)

        signatureTable.addCell(totalPriceCell)

        document.add(signatureTable)
    }

    private fun createProductsSection(document: Document, page: PdfPage, invoice: Invoice) {
        val description =
            createBoldTextParagraph("Description").setTextAlignment(TextAlignment.LEFT)

        val rate = createBoldTextParagraph("Rate").setTextAlignment(TextAlignment.CENTER)
        val quantity = createBoldTextParagraph("QTY").setTextAlignment(TextAlignment.CENTER)

        val subtotal = createBoldTextParagraph("SUBTOTAL").setTextAlignment(TextAlignment.RIGHT)

        val productsTable = Table(4, true).apply {
            setMarginLeft(15f)
            setMarginRight(15f)
            setMarginTop(50f)
        }

        productsTable.addCell(createProductTableCell(description))
        productsTable.addCell(createProductTableCell(rate))
        productsTable.addCell(createProductTableCell(quantity))
        productsTable.addCell(createProductTableCell(subtotal))

        val lightBlack = DeviceRgb(64, 64, 64)
        invoice.products.forEach { product ->
            val pDescription = createBoldTextParagraph(product.description, lightBlack)
                .setTextAlignment(TextAlignment.LEFT)

            val pRate = createBoldTextParagraph("$${product.rate}", lightBlack)
                .setTextAlignment(TextAlignment.CENTER)
            val pQuantity = createBoldTextParagraph(product.quantity.toString(), lightBlack)
                .setTextAlignment(TextAlignment.CENTER)

            val pSubtotal =
                createBoldTextParagraph("$${product.rate * product.quantity}", lightBlack)
                    .setTextAlignment(TextAlignment.RIGHT)

            productsTable.addCell(createProductTableCell(pDescription))
            productsTable.addCell(createProductTableCell(pRate))
            productsTable.addCell(createProductTableCell(pQuantity))
            productsTable.addCell(createProductTableCell(pSubtotal))
        }

        val grandTotalText = Paragraph("Grant Total")
            .setFontColor(DeviceRgb(166, 166, 166))
            .setFontSize(16f)
            .setTextAlignment(TextAlignment.RIGHT)

        val grandTotalCell = Cell(1, 4)
            .add(grandTotalText)
            .setBorder(null)
            .setBorderBottom(SolidBorder(DeviceRgb(204, 204, 204), 2f))
            .setPaddingTop(20f)
            .setPaddingTop(20f)
            .setPaddingBottom(20f)

        productsTable.addCell(grandTotalCell)
        document.add(productsTable)
        document.add(createLineSeparator())

    }

    private fun createPeopleSection(document: Document, page: PdfPage, invoice: Invoice) {

        val from = createLightTextParagraph("From").setTextAlignment(TextAlignment.LEFT)
        val to = createLightTextParagraph("to").setTextAlignment(TextAlignment.RIGHT)

        val fromName =
            createBoldTextParagraph(invoice.from.name).setTextAlignment(TextAlignment.LEFT)
        val toName =
            createBoldTextParagraph(invoice.to.name).setTextAlignment(TextAlignment.RIGHT)

        val fromAddress =
            createLightTextParagraph(invoice.from.address).setTextAlignment(TextAlignment.LEFT)
        val toAddress =
            createLightTextParagraph(invoice.from.address).setTextAlignment(TextAlignment.RIGHT)

        val peopleTable = Table(2, true).apply {
            setMarginLeft(15f)
            setMarginLeft(15f)
            setMarginTop(50f)
        }
        peopleTable.addCell(createNoBorderCell(from))
        peopleTable.addCell(createNoBorderCell(to))
        peopleTable.addCell(createNoBorderCell(fromName))
        peopleTable.addCell(createNoBorderCell(toName))
        peopleTable.addCell(createNoBorderCell(fromAddress))
        peopleTable.addCell(createNoBorderCell(toAddress))

        document.add(peopleTable)
        document.add(createLineSeparator())
    }

    private fun createTopSection(document: Document, page: PdfPage, invoice: Invoice) {
        // invoice number
        val invoiceNumber = Paragraph("Invoice #${invoice.number}")
            .setBold()
            .setFontSize(32f)

        // date
        val dateText = createLightTextParagraph(invoice.date)

        // pay button
        val payLink = Link("Pay ${invoice.price}", PdfAction.createURI(invoice.link))
            .setTextAlignment(TextAlignment.RIGHT)
            .setFontColor(DeviceRgb.WHITE)

        val payParagraph = Paragraph()
            .add(payLink)
            .setBackgroundColor(DeviceRgb(0, 92, 230))
            .setPadding(12f)
            .setWidth(100f)
            .setHorizontalAlignment(HorizontalAlignment.RIGHT)
            .setTextAlignment(TextAlignment.CENTER)

        // top section
        val topSectionTable = Table(2)
            .setMarginLeft(15f)
            .setMarginRight(15f)
            .setWidth(page.pageSize.width - 30f - 26f)

        topSectionTable.addCell(createNoBorderCell(invoiceNumber))
        topSectionTable.addCell(createNoBorderCell(payParagraph))
        topSectionTable.addCell(createNoBorderCell(dateText))



        document.add(topSectionTable)
        document.add(createLineSeparator())
    }

    private fun createLightTextParagraph(text: String): Paragraph {
        val lightTextStyle = Style().apply {
            setFontSize(12f)
            setFontColor(DeviceRgb(166, 166, 166))
        }
        return Paragraph(text).addStyle(lightTextStyle)
    }

    private fun createBoldTextParagraph(text: String, color: Color = DeviceRgb.BLACK): Paragraph {
        val boldTextStyle = Style().apply {
            setFontSize(16f)
            setFontColor(color)
            setVerticalAlignment(VerticalAlignment.MIDDLE)
            setBold()
        }
        return Paragraph(text).addStyle(boldTextStyle)
    }

    private fun createNoBorderCell(paragraph: Paragraph): Cell {
        return Cell().add(paragraph).setBorder(null)
    }

    private fun createProductTableCell(paragraph: Paragraph): Cell {
        return Cell().apply {
            add(paragraph)
            setPaddingBottom(20f)
            setPaddingTop(15f)
            setBorder(null)
            setBorderBottom(SolidBorder(DeviceRgb(204, 204, 204), 1f))
        }
    }

    private fun createLineSeparator(): LineSeparator {
        return LineSeparator(SolidLine().apply {
            color = DeviceRgb(204, 204, 204)
        }).setMarginTop(20f)
    }

    private fun calculateTotalPrice(invoice: Invoice): Double {
        return invoice.products.sumOf { it.rate.toDouble() * it.quantity }.toBigDecimal()
            .setScale(2, RoundingMode.UP).toDouble()
    }
}