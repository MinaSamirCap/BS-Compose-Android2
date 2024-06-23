package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TimeGroup(
    models: List<TimeUiModel>,
    modifier: Modifier = Modifier,
    timeSelected: ((TimeUiModel) -> Unit)? = null
) {

    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        models.forEach { model ->
            TimeItem(
                model = model,
                itemClick = {
                    timeSelected?.invoke(model)
                }
            )
        }
    }
}

@Preview
@Composable
private fun TimeGroupPreview() {
    TimeGroup(models = timeUiModels)
}