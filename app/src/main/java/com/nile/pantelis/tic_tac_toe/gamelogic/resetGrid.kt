package com.nile.pantelis.tic_tac_toe.gamelogic

import com.nile.pantelis.tic_tac_toe.domain.TileStates

fun resetGrid (
    grid: MutableList<TileStates>
): MutableList<TileStates> {
    for (i in grid.indices) {
        grid[i] = TileStates.Blank
    }
    return grid
}