package com.nile.pantelis.tic_tac_toe.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nile.pantelis.tic_tac_toe.domain.TileStates
import com.nile.pantelis.tic_tac_toe.gamerules.checkWinner

class TileViewModel: ViewModel() {
    private var _tileState =  mutableStateListOf(
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank
    )
    private var playerState = mutableStateOf(true)
    var won = mutableStateOf(false)

//    val displayPlayerTurn: String
//        get() = if (playerState) {
//            "Cross Turn"
//        } else {
//            "Circle Turn"
//        }

    val displayPlayerTurn: String
        get() = if (playerState.value) {
            "Cross Turn"
        } else {
            "Circle Turn"
        }
    val displayWinner: String
        get() = if (!playerState.value) {
            "Crosses won"
        } else {
            "Circles won"
        }

    public var tileState = _tileState

    public fun getTileState(index: Int)  {
        if (tileState[index] == TileStates.Blank) {

            if (playerState.value) {
                tileState[index] = TileStates.Cross
            } else {
                tileState[index] = TileStates.Circle
            }

            playerState.value = !playerState.value
        }

        val win = checkWinner(tileState)
        if(win) {
            won.value = true
        }

    }
    public fun clearTiles() {
        Log.d("RESTART", "CHECK")
        for (i in tileState.indices) {
            tileState[i] = TileStates.Blank
            Log.d("RESTART", displayPlayerTurn)
        }
        won.value = false
    }

}