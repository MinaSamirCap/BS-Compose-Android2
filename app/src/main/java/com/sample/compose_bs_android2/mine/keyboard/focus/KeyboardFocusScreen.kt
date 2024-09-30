package com.sample.compose_bs_android2.mine.keyboard.focus

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun KeyboardFocusScreen(modifier: Modifier = Modifier) {
    val applicationContext = LocalContext.current
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            var fullName by remember {
                mutableStateOf("")
            }

            var email by remember {
                mutableStateOf("")
            }

            var password by remember {
                mutableStateOf("")
            }

            val focusRequester = remember {
                FocusRequester()
            }

            val focusManager = LocalFocusManager.current

            TextField(
                value = fullName,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                onValueChange = {
                    fullName = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                label = { Text(text = "Full Name") }
            )

            TextField(
                value = email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                onValueChange = {
                    email = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") }
            )

            TextField(
                value = password,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone  = {
                        focusManager.clearFocus()
                        Toast.makeText(
                            applicationContext,
                            "submitted successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                ),
                onValueChange = {
                    password = it
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") }
            )

            Button(onClick = { focusRequester.requestFocus() }) {
                Text(text = "Start filling out form")
            }

            Button(onClick = {
                Toast.makeText(
                    applicationContext,
                    "submitted successfully",
                    Toast.LENGTH_LONG
                ).show()
            }) {
                Text(text = "Submit")
            }


        }
    }
}

@Preview
@Composable
private fun KeyboardFocusScreenPreview() {
    KeyboardFocusScreen()
}

/// references
// https://www.youtube.com/watch?v=CHtso6Cwi94