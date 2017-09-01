/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ai;

import tictactoe.logic.Board;

/**
 * Class for ai functions.
 * @author tomi
 */
public class AiPlayer {

    private Board board;
    private int[][] preferredMoves;

    /**
     * Constructor
     * @param board game board. 
     */
    public AiPlayer() {
        this.preferredMoves = new int[][]{{1, 1}, {0, 0}, {0, 2}, {2, 0}, {2, 2}, {0, 1}, {1, 0}, {1, 2}, {2, 1}};
    }
    
    /**
     * Super simple quick solution for ai move. Get move based on
     * simple priority.
     * @return move as int[].
     */
    public int[] move(Board board) {
        for (int[] move : preferredMoves) {
            int x = move[0];
            int y = move[1];
            if (board.nextMove(x, y)) {
                return move;
            }
        }
        return null;
    }
}
