package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.padding(vertical = 35.dp))
            FixedGrid()
        }
    }
}