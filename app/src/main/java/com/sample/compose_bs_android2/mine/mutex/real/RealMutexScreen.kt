package com.sample.compose_bs_android2.mine.mutex.real

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun RealMutexScreen(modifier: Modifier = Modifier) {

    val bank = remember { BankAccount.getInstance() }
    val scope = rememberCoroutineScope()
    val currentBalance by bank.currentBalance

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "$currentBalance", fontWeight = FontWeight.Bold)
        Text(text = "Current Balance", modifier = Modifier.alpha(0.38f))
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            scope.launch {
                bank.deposit()
            }
        }) {
            Text(text = "Deposit")
        }

        Button(onClick = {
            scope.launch {
                repeat(3) {
                    scope.launch {
                        bank.withdraw()
                    }
                }
            }
        }) {
            Text(text = "Withdraw")
        }
    }
}

@Preview
@Composable
private fun RealMutexScreenPreview() {
    RealMutexScreen()
}

/// references
// https://www.youtube.com/watch?v=RGtZXBm30RQ