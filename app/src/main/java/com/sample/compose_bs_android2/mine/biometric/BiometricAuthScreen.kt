package com.sample.compose_bs_android2.mine.biometric

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.sample.compose_bs_android2.mine.biometric.BiometricPromptManager.BiometricResult

@Composable
fun BiometricAuthScreen(modifier: Modifier = Modifier) {

    val isLocalInspect = LocalInspectionMode.current
    var promptManager: BiometricPromptManager? = null
    if (!isLocalInspect) {
        val currentActivity = LocalContext.current as FragmentActivity
        promptManager = BiometricPromptManager(currentActivity)
    }


    val biometricResult by promptManager?.promptResult!!.collectAsState(initial = null)

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            promptManager?.showBiometricPrompt(
                title = "Sample prompt",
                description = "Sample prompt description"
            )
        }) {
            Text(text = "BiometricAuth")
        }


        biometricResult?.let { result ->
            val text = when (result) {
                is BiometricResult.AuthenticationError -> result.error
                BiometricResult.AuthenticationFailed -> "Authentication Failed"
                BiometricResult.AuthenticationNotSet -> "Authentication not set"
                BiometricResult.AuthenticationSuccess -> "Authentication Success"
                BiometricResult.FeatureUnavailable -> "Authentication not exist"
                BiometricResult.HardwareUnavailable -> "Authentication not avaialbe"
            }

            Text(text = text)
        }

    }
}

@Preview
@Composable
private fun BiometricAuthScreenPreview() {
    BiometricAuthScreen()
}

/// references
// https://www.youtube.com/watch?v=_dCRQ9wta-I
// https://www.youtube.com/watch?v=qAMltd2ISz8
// https://proandroiddev.com/biometrics-in-android-50424de8d0e
// https://medium.com/@sifat.oshan/androidx-biometric-overview-3682da73f638