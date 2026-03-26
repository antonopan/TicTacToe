package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(modifier: Modifier) {
    val viewModel: TileViewModel = viewModel()
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding()
    ) {
        Box(
            modifier = Modifier
                .safeDrawingPadding()
                .fillMaxWidth(),
        ) {
            Text(
                viewModel.displayPlayerTurn,
                fontSize = 32.sp
            )
        }
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Column {
                Spacer(modifier = Modifier.padding(vertical = 35.dp))
                FixedGrid(viewModel = viewModel)
            }
        }
    }
}