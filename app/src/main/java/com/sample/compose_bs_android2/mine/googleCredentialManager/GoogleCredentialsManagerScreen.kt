package com.sample.compose_bs_android2.mine.googleCredentialManager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sample.compose_bs_android2.mine.googleCredentialManager.login.LoginScreen
import com.sample.compose_bs_android2.mine.googleCredentialManager.login.LoginViewModel
import kotlinx.serialization.Serializable

@Composable
fun GoogleCredentialsManagerScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Navigation.Login) {
        composable<Navigation.Login> {
            val viewModel = viewModel<LoginViewModel>()
            LoginScreen(state = viewModel.state, onAction = viewModel::onAction, onLoggedIn = {
                navController.navigate(Navigation.LoggedIn(it)) {
                    popUpTo(Navigation.Login) {
                        inclusive = true
                    }
                }
            })
        }

        composable<Navigation.LoggedIn> {

            val username = it.toRoute<Navigation.LoggedIn>().username

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Hello $username")
            }

        }
    }
}


private object Navigation {

    @Serializable
    object Login

    @Serializable
    data class LoggedIn(val username: String)
}

@Preview
@Composable
private fun GoogleCredentialsManagerScreenPreview() {
    GoogleCredentialsManagerScreen()
}

/// references
// https://www.youtube.com/watch?v=FULNucVxf94