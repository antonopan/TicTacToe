package com.nile.pantelis.tic_tac_toe.gamelogic

import com.nile.pantelis.tic_tac_toe.domain.GameStates
import com.nile.pantelis.tic_tac_toe.domain.TileStates

class TicTacToeAI {

    private val AI = TileStates.Cross
    private val HUMAN = TileStates.Circle
    private val EMPTY = TileStates.Blank

    fun findBestMove(board: Array<TileStates>): Pair<Int, Int>? {
        var bestScore = Int.MIN_VALUE
        var bestMove: Pair<Int, Int>? = null

        for (row in 0..2) {
            for (col in 0..2) {
                if (board[row][col] == EMPTY) {
                    board[row][col] = AI

                    val score = minimax(
                        board = board,
                        depth = 0,
                        maximizing = false
                    )

                    board[row][col] = EMPTY

                    if (score > bestScore) {
                        bestScore = score
                        bestMove = row to col
                    }
                }
            }
        }

        return bestMove
    }

    private fun minimax(
        board: Array<TileStates>,
        depth: Int,
        maximizing: Boolean
    ): Int {

        when (checkWinner(board)) {
            GameStates.Play -> return 10 - depth
            GameStates.Win -> return depth - 10
            GameStates.Tie -> return 0
        }

        return if (maximizing) {
            var bestScore = Int.MIN_VALUE

            for (row in 0..2) {
                for (col in 0..2) {
                    if (board[row][col] == EMPTY) {
                        board[row][col] = AI

                        val score = minimax(
                            board,
                            depth + 1,
                            false
                        )

                        board[row][col] = EMPTY

                        bestScore = maxOf(bestScore, score)
                    }
                }
            }

            bestScore
        } else {
            var bestScore = Int.MAX_VALUE

            for (row in 0..2) {
                for (col in 0..2) {
                    if (board[row][col] == EMPTY) {
                        board[row][col] = HUMAN

                        val score = minimax(
                            board,
                            depth + 1,
                            true
                        )

                        board[row][col] = EMPTY

                        bestScore = minOf(bestScore, score)
                    }
                }
            }

            bestScore
        }
    }

    /**
     * Returns:
     * 'X' if X wins
     * 'O' if O wins
     * 'D' if draw
     * null if game not finished
     */

}