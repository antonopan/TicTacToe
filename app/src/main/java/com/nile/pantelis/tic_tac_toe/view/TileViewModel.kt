package com.nile.pantelis.tic_tac_toe.view

import android.os.Debug
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nile.pantelis.tic_tac_toe.domain.TileStates

class TileViewModel: ViewModel() {
    private var _tileState =  mutableStateListOf(
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank,
        TileStates.Blank, TileStates.Blank, TileStates.Blank
    )
    private var playerState = mutableStateOf(true)

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

    public var tileState = _tileState

    public fun getTileState(index: Int)  {
        if (tileState[index] == TileStates.Blank) {

            if (playerState.value) {
                tileState[index] = TileStates.Cross
            } else {
                tileState[index] = TileStates.Circle
            }

            playerState.value = !playerState.value
            Log.d("Change State", playerState.value.toString())
        }

    }

}