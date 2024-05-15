package com.sample.compose_bs_android2.mine.shortcuts

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ShortcutScreen(
    modifier: Modifier = Modifier,
    intent: Intent? = null,
    viewModel: ShortcutViewModel = viewModel(),
) {

    val applicationContext = LocalContext.current
    handleIntent(intent, viewModel)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {

        when (viewModel.shortcutType) {
            ShortcutType.STATIC -> Text(text = "Static shortcut clicked")
            ShortcutType.DYNAMIC -> Text(text = "Dynamic shortcut clicked")
            ShortcutType.PINNED -> Text(text = "Pinned shortcut clicked")
            null -> Unit
        }

        Button(onClick = {
            addDynamicShortcut(applicationContext)
        }) {
            Text(text = "Add Dynamic shortcut")
        }

        Button(onClick = {
            addPinnedShortcut(applicationContext)
        }) {
            Text(text = "Add Pinned shortcut")
        }
    }
}

private fun handleIntent(intent: Intent?, viewModel: ShortcutViewModel) {

    intent?.let {
        when (intent.getStringExtra("shortcut_id")) {
            "static" -> viewModel.onShortcutClicked(ShortcutType.STATIC)
            "dynamic" -> viewModel.onShortcutClicked(ShortcutType.DYNAMIC)
            "pinned" -> viewModel.onShortcutClicked(ShortcutType.PINNED)
        }
    }
}

@Preview
@Composable
private fun ShortcutScreenPreview() {
    ShortcutScreen()
}

/// references
// https://www.youtube.com/watch?v=nXy1Zhf54fg