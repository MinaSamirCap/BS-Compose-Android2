package com.sample.compose_bs_android2.mine.pdf

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun PdfGeneratorScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val documentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            it.data?.data?.let {
                context.contentResolver.openOutputStream(it)?.let {
                    coroutineScope.launch {
                        PdfDocumentGenerator(
                            context = context,
                            outputStream = it
                        ).generateInvoicePdf(sampleInvoice)
                    }
                }
            }
        }
    )



    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_TITLE, "invoice.pdf")
            }.also {
                documentLauncher.launch(it)
            }
        }) {
            Text(text = "Save")
        }
    }
}

@Preview
@Composable
private fun PdfGeneratorScreenPreview() {
    PdfGeneratorScreen()
}

/// references
// https://www.youtube.com/watch?v=sxLAK0DpPtc&ab_channel=Landofcoding
// https://kb.itextpdf.com/itext/installing-itext-core-7-2-x-on-android