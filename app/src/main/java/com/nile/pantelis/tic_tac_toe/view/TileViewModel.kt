package com.nile.pantelis.tic_tac_toe.view

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kotlin.collections.get

class TileViewModel{
    private var _tileState =  mutableStateListOf(false, false, false, false, false, false, false, false, false)
    private var playerState = mutableStateOf(true)

    public var tileState = _tileState

    public fun getTileState(index: Int)  {
//        if(playerState.value) {
            tileState[index] = !tileState[index]
//        }

    }
}