/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author tomi
 */
public class Board {

    private char[][] board;
    private char mark;

    public Board() {
        this.board = new char[3][3];
        this.mark = 'X';
    }

    public Board(int size) {
        this.board = new char[size][size];
        this.mark = 'X';
    }

    //TODO: implement this with GUI
    public void printBoard() {
        for (int i = 0; i < board.length * 4 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("");
            for (int j = 0; j < board.length * 4 + 1; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }

    //For testing the constructors.
    public char[][] getBoard() {
        return this.board;
    }

    public void initBoard() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = '-';
            }
        }
    }

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

    //TODO: replace with mouse input (GUI)?
    public boolean nextMove(int row, int col) {
        //check that move is legit.
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if (board[row][col] == '-') {
                board[row][col] = mark;
                return true;
            }
        }
        return false;
    }

    public void changeMark() {
        if (this.mark == 'X') {
            this.mark = 'O';
        } else {
            this.mark = 'X';
        }
    }

    public boolean isWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

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
                if (board[i][board.length-1-i] != ch) {
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
