package com.sample.compose_bs_android2.mine.navigationSuite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun NavigationSuiteScreen(modifier: Modifier = Modifier) {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val windowWidthClass = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            SuiteScreen.entries.forEachIndexed { index, suiteScreen ->
                item(
                    selected = index == selectedIndex,
                    onClick = {
                        selectedIndex = index
                    },
                    icon = {
                        Icon(imageVector = suiteScreen.icon, contentDescription = suiteScreen.title)
                    },
                    label = {
                        Text(text = suiteScreen.title)
                    }
                )
            }
        },
        layoutType = if (windowWidthClass == WindowWidthSizeClass.EXPANDED) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
                currentWindowAdaptiveInfo()
            )
        }
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            SuiteScreen.entries.forEachIndexed { index, suiteScreen ->
                if (index == selectedIndex) {
                    Text(text = suiteScreen.title)
                }
            }
        }
    }
}

@Preview
@PreviewScreenSizes
@Composable
private fun NavigationSuiteScreenPreview() {
    NavigationSuiteScreen()
}

/// references
// https://www.youtube.com/watch?v=u8vQgmgf3X4