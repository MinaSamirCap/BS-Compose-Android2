package com.sample.compose_bs_android2.mine.multiBackstack

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sample.compose_bs_android2.mine.multiBackstack.components.ChatNavHost
import com.sample.compose_bs_android2.mine.multiBackstack.components.HomeNavHost
import com.sample.compose_bs_android2.mine.multiBackstack.components.SettingsNavHost
import com.sample.compose_bs_android2.mine.multiBackstack.helpers.NavigationHelper

@Composable
fun MultiBackstackScreen(modifier: Modifier = Modifier) {

    val rootNavController = rememberNavController()
    val navBackstackEntry by rootNavController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationHelper.items.forEach { item ->

                    val isSelected = item.title.lowercase() == navBackstackEntry?.destination?.route

                    NavigationBarItem(
                        selected = isSelected,
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            val icon = if (isSelected) item.selectedIcon else item.unselectedIcon
                            Icon(
                                imageVector = icon,
                                contentDescription = item.title
                            )
                        },
                        onClick = {
                            // The magic of multi backstack happens here ....

                            // first --> We are using rootNavController to navigate to the top destinations (Main 3 tabs)
                            rootNavController.navigate(item.title.lowercase()) {
                                // second --> After we navigated to the needed destinations from the top destination
                                // we will pop up other destinations and save its states to avoid using very large memory
                                popUpTo(rootNavController.graph.findStartDestination().id) {
                                    // actual save of the states
                                    saveState = true
                                }
                                // Third --> We are using launchSingleTop to avoid creating multiple instances of the same destination
                                // means if I am in the first tab and pressed on first tab again, it will not recreate a new instance.
                                launchSingleTop = true

                                // Forth --> When we are back to a previous destination, we want to restore its state.
                                restoreState = true
                            }
                        },
                    )

                }
            }
        }
    ) { padding ->

        // Fifth --> When we have multiple backstack, each tab should have its own navigation controller.

        NavHost(
            modifier = modifier.padding(padding),
            navController = rootNavController,
            startDestination = "home"
        ) {

            composable("home") {
                HomeNavHost()
            }

            composable("chat") {
                ChatNavHost()
            }

            composable("settings") {
                SettingsNavHost()
            }

        }
    }
}

@Preview
@Composable
private fun MultiBackstackScreenPreview() {
    MultiBackstackScreen()
}

/// references
// https://www.youtube.com/watch?v=fp1-YSmdzh8&ab_channel=PhilippLackner