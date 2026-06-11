package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.nile.pantelis.tic_tac_toe.domain.GameStates

@Composable
fun WinnerPopup(
    onConfirmation: () -> Unit,
    dialogText: String,
    onDismissRequest: () -> Unit,
    winState: GameStates
) {
    var winText: String = ""
    if (winState == GameStates.Win) {
        winText = dialogText
    }
    else if (winState == GameStates.Tie) {
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