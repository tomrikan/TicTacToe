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
public class MainGame {
    public static void main(String[] args) {
        //TESTING-TESTING-TESTING
        Board board = new Board();
        board.initBoard();
        board.playerMove(0, 0);
        board.changePlayer();
        board.printBoard();
        board.playerMove(1, 1);
        board.changePlayer();
        board.printBoard();
        
        System.out.println("");
        
        Board board2 = new Board(9);
        board2.initBoard();
        board2.printBoard();
    }
}
