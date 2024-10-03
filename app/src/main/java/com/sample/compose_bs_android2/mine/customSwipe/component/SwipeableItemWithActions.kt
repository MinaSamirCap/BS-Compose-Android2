package com.sample.compose_bs_android2.mine.customSwipe.component


import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeableItemWithActions(
    isRevealed: Boolean, // to programmatically swipe the item or not ...
    actions: @Composable RowScope.() -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    onExpanded: () -> Unit = {},
    onCollapsed: () -> Unit = {}
) {

    /// represents the width of the menu behind the foreground content.
    var contextMenuWidth by remember {
        mutableFloatStateOf(0f)
    }

    /// this offset to animate the item the drawing above the menu to the end of menu
    /// in case of half of menu already appears, and animate back till the start of the row
    /// if we did not pass the half of menu.
    val offset = remember {
        Animatable(initialValue = 0f)
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(isRevealed, contextMenuWidth) {
        if (isRevealed) {
            offset.animateTo(contextMenuWidth)
        } else {
            offset.animateTo(0f)
        }
    }


    Box(
        modifier = modifier
            .fillMaxWidth()
            /// IntrinsicSize.Min means to set the height of compose to the minimum height of children
            .height(IntrinsicSize.Min)
    ) {
        Row(
            modifier = Modifier
                .onSizeChanged {
                    /// to update the menu width for each change.
                    contextMenuWidth = it.width.toFloat()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            actions()
        }

        /// first we wrap the content with Surface to add the swipe action.
        Surface(
            modifier = Modifier
                .fillMaxSize()
                /// we are using offset with lambda not the function ...
                /// the offset() will cause the recomposition with each change ..

                /// This modifier is designed to be used for offsets that change,
                /// possibly due to user interactions.
                /// It avoids recomposition when the offset is changing,
                /// and also adds a graphics layer that prevents unnecessary redrawing
                /// of the context when the offset is changing.
                .offset { IntOffset(offset.value.roundToInt(), 0) }

                /// pointer modifier will help us to detect the horizontal gesture...
                /// in the horizontal gesture itself, we are care about onDrag and onEnd
                .pointerInput(contextMenuWidth) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            scope.launch {
                                /// .coerceIn(0f, contextMenuWidth) means the max drag will be
                                /// the size of menu, and min drag can not be less 0f
                                /// so, .coerceIn(0f, contextMenuWidth) help us to add constrains
                                /// to the drag ...
                                val newOffset = (offset.value + dragAmount)
                                    .coerceIn(0f, contextMenuWidth)
                                offset.snapTo(newOffset)
                            }
                        },
                        onDragEnd = {
                            when {
                                offset.value >= contextMenuWidth / 2f -> {
                                    scope.launch {
                                        offset.animateTo(contextMenuWidth)
                                        onExpanded()
                                    }
                                }

                                else -> {
                                    scope.launch {
                                        offset.animateTo(0f)
                                        onCollapsed()
                                    }
                                }
                            }
                        }
                    )
                }

        ) {
            content()
        }
    }

}