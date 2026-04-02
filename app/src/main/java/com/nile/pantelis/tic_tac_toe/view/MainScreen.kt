package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(modifier: Modifier) {
    val viewModel: TileViewModel = viewModel()
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    viewModel.displayPlayerTurn,
                    fontSize = 32.sp,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Box(
                modifier = Modifier
                    .clickable(onClick = { viewModel.clearTiles() })
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Restart",
                    fontSize = 16.sp
                )
            }
        }
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                FixedGrid(viewModel = viewModel)
            }
        }
    }
    if (viewModel.won) {
        WinnerPopup(onConfirmation = {
            viewModel.clearTiles()
            viewModel.won = false
                                     }, dialogText = viewModel.displayPlayerTurn)
    }
}
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(modifier = Modifier)
}