package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.nile.pantelis.tic_tac_toe.domain.TileStates
import com.nile.pantelis.tic_tac_toe.ui.theme.BoardColor
import com.nile.pantelis.tic_tac_toe.ui.theme.GridColor

@Composable
fun FixedGrid(viewModel: TileViewModel) {

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize().padding(vertical = 40.dp, horizontal = 10.dp)
    ) {
        val gridHeight = maxHeight

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize()
                .background(GridColor),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)

            ) {
            items(9) { index ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(gridHeight/3)
                        .background(BoardColor)
//                    .height(270.dp)
                        .border(4.dp, Color.Transparent)
                        .clickable(
                            onClick = { viewModel.getTileState(index)  },
                            indication = null,
                            interactionSource = null
                            ),
                    contentAlignment = Alignment.Center,
                ) {
//                    var state: Boolean = false
                    when{
                        viewModel.tileState[index] == TileStates.Blank -> {}

                        viewModel.tileState[index] == TileStates.Cross -> {
                            Symbols(infiniteTransition = rememberInfiniteTransition(), turn = true)
                        }

                        viewModel.tileState[index] == TileStates.Circle -> {
                            Symbols(infiniteTransition = rememberInfiniteTransition(), turn = false)
                        }
                    }

                }
            }
        }
    }
}
