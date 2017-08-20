/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

/**
 * Class for board logic.
 *
 * @author tomi
 */
public class Board {

    private char[][] board;
    private char mark;

    /**
     * Normal constructor.
     */
    public Board() {
        this.board = new char[3][3];
        this.mark = 'X';
    }

    /**
     * Constructor for customized size.
     *
     * @param size board's size.
     */
    public Board(int size) {
        this.board = new char[size][size];
        this.mark = 'X';
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getMark() {
        return this.mark;
    }

    /**
     * Initializes the board.
     */
    public void initBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * Checks whether board is full or not.
     *
     * @return isFull
     */
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    /**
     * Check that proposed move is correct and if so place it on the board.
     *
     * @param row
     * @param col
     * @return true if move correct, false if not.
     */
    public boolean nextMove(int row, int col) {
        //check that move is legit and input it if so.
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if (board[row][col] == '-') {
                board[row][col] = mark;
                return true;
            }
        }
        return false;
    }

    /**
     * Changes the current playing mark.
     */
    public void changeMark() {
        if (this.mark == 'X') {
            this.mark = 'O';
        } else {
            this.mark = 'X';
        }
    }
}
