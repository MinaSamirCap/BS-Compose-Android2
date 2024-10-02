package com.sample.compose_bs_android2.approaches.localComposition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.approaches.localComposition.componets.DisplayImageOfIsSpicyOrNot

@Composable
fun LocalSpicyScreen(modifier: Modifier = Modifier) {
    val isSpicy = true

    CompositionLocalProvider(value = LocalSpicy provides isSpicy) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Is Spicy: ${LocalSpicy.current}")
            DisplayImageOfIsSpicyOrNot()

            CompositionLocalProvider(value = LocalSpicy provides false) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = "Is Spicy: ${LocalSpicy.current}")
                    DisplayImageOfIsSpicyOrNot()

                    CompositionLocalProvider(value = LocalSpicy provides true) {
                        Column(
                            modifier = modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(text = "Is Spicy: ${LocalSpicy.current}")
                            DisplayImageOfIsSpicyOrNot()


                        }
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun LocalSpicyScreenPreview() {
    LocalSpicyScreen()
}

/// references
// https://www.youtube.com/watch?v=0tNCR8U-kvc