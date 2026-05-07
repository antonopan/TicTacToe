package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign

@Composable
fun WinnerPopup(
    onConfirmation: () -> Unit,
    dialogText: String,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        title = {
            Text(text = "WINNER")
        },
        text = {
            Text(
                text = dialogText,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Restart")
            }

        },
    )
}