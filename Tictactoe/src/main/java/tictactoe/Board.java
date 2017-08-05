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
    private char player;

    public Board() {
        this.board = new char[3][3];
        this.player = 'X';
    }

    public Board(int size) {
        this.board = new char[size][size];
        this.player = 'X';
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
    public int getBoardSize() {
        return this.board.length;
    }

    public void initBoard() {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = '-';
            }
        }
    }

    public boolean checkIfFull() {
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
    public void playerMove(int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if (board[row][col] == '-') {
                board[row][col] = player;
            }
        }
    }

    public void changePlayer() {
        if (this.player == 'X') {
            this.player = 'O';
        } else {
            this.player = 'X';
        }
    }
}
