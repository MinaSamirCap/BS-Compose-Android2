package com.sample.compose_bs_android2.mine.previewMode

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import com.sample.compose_bs_android2.mine.previewMode.components.ImageComponent

@Composable
fun PreviewModeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val isPreviewMode = LocalInspectionMode.current

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val text =
                if (isPreviewMode) "This is only displayed in a preview" else "This is only displayed in live code"
            Text(text)
            Text("This should always be displayed")
            ImageComponent()
        }
    }
}

@Preview
@Composable
private fun PreviewModeScreenPreview() {
    PreviewModeScreen()
}

/// references
// https://www.droidcon.com/2024/05/06/only-show-the-tip-of-the-iceberg/?mc_cid=fd53e4c774