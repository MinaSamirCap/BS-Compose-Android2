package com.sample.compose_bs_android2.mine.waterBottle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sample.compose_bs_android2.mine.waterBottle.components.WaterBottle

@Composable
fun WaterBottleScreen(modifier: Modifier = Modifier) {

    val totalAmount by remember { mutableIntStateOf(2400) }
    var usedAmount by remember { mutableIntStateOf(400) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WaterBottle(
            totalWaterAmount = totalAmount,
            usedWaterAmount = usedAmount,
            unit = "ml",
            modifier = Modifier.width(250.dp)
        )

        Text(text = "Total amount: $totalAmount")

        Button(onClick = {
            usedAmount += 200
        }) {
            Text(text = "Drink")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterBottleScreenPreview() {
    WaterBottleScreen()
}

/// references
// https://www.youtube.com/watch?v=vmT0SScA2lA