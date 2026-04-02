package com.nile.pantelis.tic_tac_toe.gamerules

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.nile.pantelis.tic_tac_toe.domain.TileStates

fun checkWinner(gameState: SnapshotStateList<TileStates>): Boolean {
    for (i in 0..2) {
        when {
            //vertical win
            gameState[i] != TileStates.Blank && gameState[i] == gameState[i+3] && gameState[i+3] == gameState[i+6] -> return true
            //horizontal win
            gameState[i*3] != TileStates.Blank && gameState[i*3] == gameState[i*3+1] && gameState[i*3+1] == gameState[i*3+2] -> return true
            //diagonal win 1
            gameState[0] != TileStates.Blank && gameState[0] == gameState[4] && gameState[4] == gameState[8] -> return true
            //diagonal win 2
            gameState[2] != TileStates.Blank && gameState[2] == gameState[4] && gameState[4] == gameState[6] -> return true
        }
    }
    return false
}
