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
        board.nextMove(2, 2);
        System.out.println(board.isWinner());
        board.nextMove(1, 1);
        System.out.println(board.isWinner());
        board.changeMark();
        board.nextMove(2, 0);
        System.out.println(board.isWinner());
        board.printBoard();

        System.out.println("");

        Board board2 = new Board(4);
        board2.initBoard();
        board2.printBoard();
    }
}
