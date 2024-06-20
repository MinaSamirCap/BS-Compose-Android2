package com.sample.compose_bs_android2.mine.pdf

import android.content.Context
import com.itextpdf.io.font.constants.StandardFonts
import com.itextpdf.kernel.colors.DeviceRgb
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.action.PdfAction
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.LineSeparator
import com.itextpdf.layout.element.Link
import com.itextpdf.layout.element.List
import com.itextpdf.layout.element.Paragraph
import com.itextpdf.layout.element.Table
import com.itextpdf.layout.properties.ListNumberingType
import com.itextpdf.layout.properties.TextAlignment
import java.io.File

fun createPdf(context: Context) {
    val outputFile = File(context.filesDir, "test.pdf")
    val pdfWriter = PdfWriter(outputFile)
    val pdfDocument = PdfDocument(pdfWriter)
    val document = Document(pdfDocument, PageSize.A3)

    // we need to create a page first so, we can start to add content in page itself
    pdfDocument.addNewPage()

    document.setMargins(0f, 0f, 0f, 0f)

    // add paragraph
    val helloWorld = Paragraph("Hello World!")
        .setTextAlignment(TextAlignment.CENTER)
        .setFontSize(22f)
        .setFontColor(DeviceRgb.BLUE)
        .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
    document.add(helloWorld)

    // add list
    val list = List()
    list.add("Item 1")
    list.add("Item 2")
    list.add("Item 3")
    //list.setListSymbol(Text("$$"))
    list.setListSymbol(ListNumberingType.DECIMAL)
    document.add(list)

    // add link
    val link = Link("Link", PdfAction.createURI("https://www.google.com"))
        .setBold().setUnderline()
    document.add(Paragraph().add(link))

    // add line separator
    val lineSeparator = LineSeparator(SolidLine())
    document.add(lineSeparator)
    document.add(Paragraph().add(link))
    document.add(lineSeparator)
    document.add(Paragraph().add(link))
    document.add(lineSeparator)
    document.add(Paragraph().add(link))
    document.add(lineSeparator)

    // add table
    val table = Table(3, true) // true means here the table will take the full width.

    table.addCell(Paragraph("Column 1").setTextAlignment(TextAlignment.CENTER))
    table.addCell("Column 2")
    table.addCell("Column 3")

    table.addCell("Row 1, Column 1")
    table.addCell("Row 1, Column 2")
    table.addCell("Row 1, Column 3")

    table.addCell("Row 2, Column 1")
    table.addCell("Row 2, Column 2")
    table.addCell("Row 2, Column 3")

    document.add(table)

    document.close()
}