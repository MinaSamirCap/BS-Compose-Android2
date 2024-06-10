package com.sample.compose_bs_android2.mine.waterBottle.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WaterBottle(
    totalWaterAmount: Int,
    usedWaterAmount: Int,
    unit: String,
    modifier: Modifier = Modifier,
    waterColor: Color = Color(0xFF279EFF),
    bottleColor: Color = Color.White,
    capColor: Color = Color(0xFF0065b9)

) {

    val waterPercentage = animateFloatAsState(
        targetValue = usedWaterAmount.toFloat() / totalWaterAmount.toFloat(),
        label = "Water waves animation",
        animationSpec = tween(durationMillis = 1000)
    ).value

    val usedAmountAnimation = animateIntAsState(
        targetValue = usedWaterAmount,
        label = "Water waves animation",
        animationSpec = tween(durationMillis = 1000)
    ).value

    Box(
        modifier = modifier
            .width(200.dp)
            .height(600.dp)
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            val capWidth = size.width * 0.55f
            val capHeight = size.height * 0.13f

            val bottleBodyPath = Path().apply {

                // leave space for cap and start drawing
                moveTo(x = width * 0.3f, y = height * 0.1f)

                // left nick of the bottle
                lineTo(x = width * 0.3f, y = height * 0.2f)

                // left upper curve of bottle
                quadraticTo(
                    x1 = 0f, y1 = height * 0.3f,
                    x2 = 0f, y2 = height * 0.4f
                )

                // left height of bottle
                lineTo(x = 0f, y = height * 0.95f)

                // left bottom curve of bottle
                quadraticTo(
                    x1 = 0f, y1 = height,
                    x2 = width * 0.05f, y2 = height
                )

                // bottom line of bottle
                lineTo(x = width * 0.95f, y = height)

                // right bottom curve of bottle
                quadraticTo(
                    x1 = width, y1 = height,
                    x2 = width, y2 = height * 0.95f
                )

                // right height of bottle
                lineTo(x = width, y = height * 0.4f)

                // left upper curve of bottle
                quadraticTo(
                    x1 = width, y1 = height * 0.3f,
                    x2 = width * 0.7f, y2 = height * 0.2f
                )

                // right nick of the bottle
                lineTo(x = width * 0.7f, y = height * 0.1f)
                close()
            }

            clipPath(bottleBodyPath) {
                drawRect(
                    color = bottleColor,
                    size = size
                )

                val waterWavesYPosition = (1 - waterPercentage) * size.height
                val waterPath = Path().apply {
                    moveTo(x = 0f, y = waterWavesYPosition)
                    lineTo(x = size.width, y = waterWavesYPosition)
                    lineTo(x = size.width, y = size.height)
                    lineTo(x = 0f, y = size.height)
                    close()
                }

                drawPath(
                    path = waterPath,
                    color = waterColor
                )
            }

            // draw the cap
            drawRoundRect(
                color = capColor,
                size = Size(capWidth, capHeight),
                topLeft = Offset(size.width / 2 - capWidth / 2f, 0f),
                cornerRadius = CornerRadius(x = 45f, y = 45f)
            )

        }

        val text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5f) bottleColor else waterColor,
                    fontSize = 44.sp
                )

            ) {
                append("$usedAmountAnimation")
            }

            withStyle(
                style = SpanStyle(
                    color = if (waterPercentage > 0.5f) bottleColor else waterColor,
                    fontSize = 22.sp
                )

            ) {
                append(" $unit")
            }
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text)
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun WaterBottlePreview() {
    WaterBottle(
        totalWaterAmount = 1000,
        usedWaterAmount = 300,
        unit = "ml"
    )
}