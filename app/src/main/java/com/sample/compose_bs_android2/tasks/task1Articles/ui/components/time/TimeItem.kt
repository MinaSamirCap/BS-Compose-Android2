package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TimeItem(
    model: TimeUiModel,
    modifier: Modifier = Modifier,
    itemClick: (TimeUiModel) -> Unit = {},
) {
    FilterChip(
        modifier = modifier,
        selected = model.isSelected,
        leadingIcon = {
            if (model.isSelected) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )
            }
        },
        onClick = {
            itemClick(model)
        }, label = {
            Text(text = model.title)
        }
    )
}

@Preview
@Composable
private fun TimeItemPreview1() {
    TimeItem(timeUiModels[0])
}

@Preview
@Composable
private fun TimeItemPreview2() {
    TimeItem(timeUiModels[1].copy(isSelected = true))
}