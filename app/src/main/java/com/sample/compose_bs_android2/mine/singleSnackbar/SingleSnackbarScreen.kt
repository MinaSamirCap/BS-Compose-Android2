package com.sample.compose_bs_android2.mine.singleSnackbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.compose_bs_android2.mine.singleSnackbar.screenA.SingleSnackbarScreenA
import com.sample.compose_bs_android2.mine.singleSnackbar.screenB.SingleSnackbarScreenB
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Composable
fun SingleSnackbarScreen(modifier: Modifier = Modifier) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val coroutineScope = rememberCoroutineScope()
    ObserveAsEvents(
        flow = SnackbarController.events,
        snackbarHostState
    ) { event ->
        coroutineScope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
            val result = snackbarHostState.showSnackbar(
                message = event.message,
                actionLabel = event.action?.name,
                duration = SnackbarDuration.Long
            )
            if (result == SnackbarResult.ActionPerformed) {
                event.action?.action?.invoke()
            }
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController, startDestination = Navigation.ScreenA
        ) {

            composable<Navigation.ScreenA> {
                SingleSnackbarScreenA(onNavigate = {
                    navController.navigate(Navigation.ScreenB)
                })
            }

            composable<Navigation.ScreenB> {
                SingleSnackbarScreenB()
            }
        }
    }
}


private object Navigation {

    @Serializable
    object ScreenA

    @Serializable
    object ScreenB

}

@Preview
@Composable
private fun SingleSnackbarScreenPreview() {
    SingleSnackbarScreen()
}

/// references
// https://www.youtube.com/watch?v=KFazs62lIkE