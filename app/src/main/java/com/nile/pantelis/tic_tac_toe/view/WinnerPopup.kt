package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun WinnerPopup(
    onConfirmation: () -> Unit,
    dialogText: String,
    onDismissRequest: () -> Unit,
    winState: Int
) {
    var winText: String = ""
    if (winState == 1 ) {
        winText = dialogText
    }
    else if (winState == 2) {
        winText = "It's a tie!"
    }
    AlertDialog(
        title = {
            Text(text = "WINNER")
        },
        text = {
            Text(
                text = winText,
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