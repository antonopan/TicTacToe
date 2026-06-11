package com.nile.pantelis.tic_tac_toe.gamelogic

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.nile.pantelis.tic_tac_toe.domain.GameStates
import com.nile.pantelis.tic_tac_toe.domain.TileStates


fun checkWinner(gameState: SnapshotStateList<TileStates>): GameStates {
    for (i in 0..2) {
        when {
            //vertical win
            gameState[i] != TileStates.Blank && gameState[i] == gameState[i+3] && gameState[i+3] == gameState[i+6] -> return GameStates.Win
            //horizontal win
            gameState[i*3] != TileStates.Blank && gameState[i*3] == gameState[i*3+1] && gameState[i*3+1] == gameState[i*3+2] -> return GameStates.Win
            //diagonal win 1
            gameState[0] != TileStates.Blank && gameState[0] == gameState[4] && gameState[4] == gameState[8] -> return GameStates.Win
            //diagonal win 2
            gameState[2] != TileStates.Blank && gameState[2] == gameState[4] && gameState[4] == gameState[6] -> return GameStates.Win
        }
    }
    if (checkTie(gameState)) return GameStates.Tie
     return GameStates.Play
}

private fun checkTie(gameState: SnapshotStateList<TileStates>): Boolean {
    for (u in 0..8){
        if (gameState[u] == TileStates.Blank) {
            return false
        }
    }
    return true
}
