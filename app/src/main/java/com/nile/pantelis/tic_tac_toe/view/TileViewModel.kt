package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nile.pantelis.tic_tac_toe.domain.GameStates
import com.nile.pantelis.tic_tac_toe.domain.TileStates
import com.nile.pantelis.tic_tac_toe.gamelogic.checkWinner

class TileViewModel : ViewModel() {
    private var _tileState = mutableStateListOf(
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank
    )
    var playerState = mutableStateOf(true)
    var won = mutableStateOf(GameStates.Play)

    var restart: Boolean by mutableStateOf(false)

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

    public fun getTileState(index: Int) {
        if (tileState[index] == TileStates.Blank) {

            if (playerState.value) {
                tileState[index] = TileStates.Cross
            } else {
                tileState[index] = TileStates.Circle
            }

            playerState.value = !playerState.value

            won.value = checkWinner(_tileState)
        }
    }
}
