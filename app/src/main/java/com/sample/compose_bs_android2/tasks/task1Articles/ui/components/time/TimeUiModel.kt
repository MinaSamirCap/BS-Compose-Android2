package com.sample.compose_bs_android2.tasks.task1Articles.ui.components.time

data class TimeUiModel(
    val title: String,
    var isSelected: Boolean = false
)

const val lastDay = "Last Day"
const val lastWeek = "Last Week"
const val lastMonth = "Last Month"

val timeUiModels = listOf(
    TimeUiModel(lastDay, false),
    TimeUiModel(lastWeek, false),
    TimeUiModel(lastMonth, false),
)