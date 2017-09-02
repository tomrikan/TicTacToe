/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

/**
 * Class for checking for possible win on the board.
 * @author tomi
 */
public class WinnerChecker {
    
    /**
     * Empty constructor.
     */
    public WinnerChecker() {
    }
    
    /**
     * Check if the board contains win. Uses sub methods for row-, column- and
     * diagonal wise checking.
     * @param board as game board.
     * @return true if win found, otherwise false.
     */
    public boolean isWinner(Board board) {
        return (checkRows(board) || checkColumns(board) || checkDiagonals(board));
    }

    private boolean checkRows(Board board) {
        char ch = 'y';

        //Iterate through the table row wise.
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][0] != '-') {
                ch = board.getBoard()[i][0];

                for (int j = 1; j < board.getBoard().length; j++) {
                    if (board.getBoard()[i][j] != ch) {
                        break;
                    }
                    if (j == board.getBoard().length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkColumns(Board board) {
        char ch = 'y';
        //Iterate through the table column wise.
        for (int j = 0; j < board.getBoard().length; j++) {
            if (board.getBoard()[0][j] != '-') {
                ch = board.getBoard()[0][j];

                for (int i = 1; i < board.getBoard().length; i++) {
                    if (board.getBoard()[i][j] != ch) {
                        break;
                    }
                    if (i == board.getBoard().length - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals(Board board) {
        //iterate through both diagonals
        char ch = 'y';
        if (board.getBoard()[0][0] != '-') {
            ch = board.getBoard()[0][0];

            for (int i = 1; i < board.getBoard().length; i++) {
                if (board.getBoard()[i][i] != ch) {
                    break;
                }
                if (i == board.getBoard().length - 1) {
                    return true;
                }
            }
        }
        if (board.getBoard()[0][board.getBoard().length - 1] != '-') {
            ch = board.getBoard()[0][board.getBoard().length - 1];
            for (int i = 1; i < board.getBoard().length; i++) {
                if (board.getBoard()[i][board.getBoard().length - 1 - i] != ch) {
                    break;
                }
                if (i == board.getBoard().length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}