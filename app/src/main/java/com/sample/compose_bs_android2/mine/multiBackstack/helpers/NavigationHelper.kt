package com.sample.compose_bs_android2.mine.multiBackstack.helpers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector


class NavigationHelper {
    companion object {
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                unselectedIcon = Icons.Outlined.Home,
                selectedIcon = Icons.Filled.Home
            ),
            BottomNavigationItem(
                title = "Chat",
                unselectedIcon = Icons.Outlined.Email,
                selectedIcon = Icons.Filled.Email
            ),
            BottomNavigationItem(
                title = "Settings",
                unselectedIcon = Icons.Outlined.Settings,
                selectedIcon = Icons.Filled.Settings
            )
        )
    }
}

data class BottomNavigationItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector
)