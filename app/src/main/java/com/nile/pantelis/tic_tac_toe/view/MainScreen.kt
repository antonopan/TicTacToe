package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nile.pantelis.tic_tac_toe.domain.GameStates
import com.nile.pantelis.tic_tac_toe.domain.TileStates
import com.nile.pantelis.tic_tac_toe.gamelogic.resetGrid

@Composable
fun MainScreen(modifier: Modifier) {
    val viewModel: TileViewModel = viewModel()
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .weight(0.05f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    viewModel.displayPlayerTurn,
                    fontSize = 32.sp,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .clickable(onClick = {
                        viewModel.tileState = resetGrid(grid = viewModel.tileState) as SnapshotStateList<TileStates>
                        viewModel.won.value = GameStates.Play
                    })
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Restart",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
        Box(
            modifier = modifier.fillMaxSize()
                .weight(1f)
        ) {
            Column {
                FixedGrid(viewModel = viewModel)
            }
        }
    }

    if (viewModel.won.value != GameStates.Play) {
        WinnerPopup(onConfirmation = {
            viewModel.tileState = resetGrid(grid = viewModel.tileState) as SnapshotStateList<TileStates>
            viewModel.won.value = GameStates.Play
            viewModel.restart = true
            },
            dialogText = viewModel.displayWinner,
            onDismissRequest = {},
            winState = viewModel.won.value
        )
    }
    if (viewModel.restart) {
        RestartPopup(
            onConfirmation = {
                viewModel.restart = false
                viewModel.playerState.value = true
                             },
            onDismissRequest = {
                viewModel.restart = false
                viewModel.playerState.value = false

            }
        ) }
}
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(modifier = Modifier)
}