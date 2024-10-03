package com.sample.compose_bs_android2.mine.customSwipe

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sample.compose_bs_android2.mine.customSwipe.component.ContactUiModel
import com.sample.compose_bs_android2.mine.customSwipe.component.SwipeActionIcon
import com.sample.compose_bs_android2.mine.customSwipe.component.SwipeableItemWithActions

@Composable
fun CustomSwipeScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val contacts = remember {
        mutableStateListOf(
            *(0..100).map {
                ContactUiModel(
                    id = it,
                    name = "Contact $it",
                    isOptionsRevealed = false

                )
            }.toTypedArray()
        )
    }

    LazyColumn(modifier = modifier.fillMaxSize()) {

        itemsIndexed(
            items = contacts,
            key = { index, contact -> contact.id }
        ) { index, contact ->
            SwipeableItemWithActions(
                isRevealed = contact.isOptionsRevealed,
                onExpanded = {
                    contacts[index] = contact.copy(isOptionsRevealed = true)
                },
                onCollapsed = {
                    contacts[index] = contact.copy(isOptionsRevealed = false)
                },
                actions = {
                    SwipeActionIcon(
                        onClick = {
                            contacts.remove(contact)
                            showToast(context, "Contact ${contact.name} was deleted.")
                        },
                        backgroundColor = Color.Red,
                        icon = Icons.Default.Delete,
                        modifier = Modifier.fillMaxHeight()
                    )
                    SwipeActionIcon(
                        onClick = {
                            showToast(context, "Contact ${contact.name} has sent an email.")
                            contacts[index] = contact.copy(isOptionsRevealed = false)
                        },
                        backgroundColor = Color.Blue,
                        icon = Icons.Default.Email,
                        modifier = Modifier.fillMaxHeight()
                    )
                    SwipeActionIcon(
                        onClick = {
                            showToast(context, "Contact ${contact.name} was shared.")
                            contacts[index] = contact.copy(isOptionsRevealed = false)
                        },
                        backgroundColor = Color.Black,
                        icon = Icons.Default.Share,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
                content = {
                    val color = if (index % 2 == 0) Color.Green else Color.White
                    Text(
                        text = contact.name,
                        fontSize = 22.sp,
                        modifier = modifier
                            .background(color)
                            .padding(8.dp)
                    )
                })
        }
    }
}


private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview
@Composable
private fun CustomSwipeScreenPreview() {
    CustomSwipeScreen()
}

/// references
// https://www.youtube.com/watch?v=-L_d-0Emmwc