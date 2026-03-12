package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nile.pantelis.tic_tac_toe.R

@Composable
fun FixedGrid() {

   val viewModel: TileViewModel = TileViewModel()
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val gridHeight = maxHeight

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize()
                .background(Color.Gray),

            ) {
            items(9) { index ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(gridHeight/3)
//                    .height(270.dp)
                        .border(1.dp, Color.Black)
                        .clickable(onClick = { viewModel.getTileState(index)  })
                        .background(Color.Cyan),
                    contentAlignment = Alignment.Center
                ) {
//                    var state: Boolean = false
                    if (viewModel.tileState[index]) {
                        Icon(painterResource(id = R.drawable.circle), contentDescription = "Circle")
                    }
                    else {
                        Icon(painterResource(id = R.drawable.cross), contentDescription = "Cross")
                    }

                }
            }
        }
    }
}

@Composable
@Preview
fun FixedGridPreview(){
    FixedGrid()
}