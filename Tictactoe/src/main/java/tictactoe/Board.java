/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 * Class for board logic.
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
     * @param size board's size.
     */
    public Board(int size) {
        this.board = new char[size][size];
        this.mark = 'X';
    }
    
    /**
     * Getter for board.
     * @return board.
     */
    public char[][] getBoard() {
        return this.board;
    }
    
    /**
     * Returns current playing mark.
     * @return mark
     */
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
    
    /**
     * Checks for possible winner. Method uses three sub methods to check the board.
     * @return true if there is winner and false if not.
     */
    public boolean isWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }
    
    /**
     * Checks the rows for win. Used by method isWinner().
     * @return true if winning row found, false if not.
     */
    private boolean checkRows() {
        char ch = 'y';

        //Iterate through the table row wise.
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != '-') {
                ch = board[i][0];

                for (int j = 1; j < board.length; j++) {
                    if (board[i][j] != ch) {
                        break;
                    }
                    if (j == board.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Checks columns for win. Used by method isWinner().
     * @return true if win, false if not.
     */
    private boolean checkColumns() {
        char ch = 'y';
        //Iterate through the table column wise.
        for (int j = 0; j < board.length; j++) {
            if (board[0][j] != '-') {
                ch = board[0][j];

                for (int i = 1; i < board.length; i++) {
                    if (board[i][j] != ch) {
                        break;
                    }
                    if (i == board.length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Checks diagonals for win. Both diagonals checked after each other.
     * Used by method isWinner().
     * @return true if win found, false if not.
     */
    private boolean checkDiagonals() {
        char ch = 'y';
        if (board[0][0] != '-') {
            ch = board[0][0];

            for (int i = 1; i < board.length; i++) {
                if (board[i][i] != ch) {
                    break;
                }
                if (i == board.length - 1) {
                    return true;
                }
            }
        }
        if (board[0][board.length - 1] != '-') {
            for (int i = 1; i < board.length; i++) {
                if (board[i][board.length - 1 - i] != ch) {
                    break;
                }
                if (i == board.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
