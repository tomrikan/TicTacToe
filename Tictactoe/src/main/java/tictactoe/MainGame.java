/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author tomi
 */
public class MainGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("TIC-TAC-TOE");

        while (choice < 1 || choice > 3) {
            System.out.println("Choose 1 for normal size board, 2 for custom size, any other number for quit: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice == 1) {
                    Board board = new Board();
                    board.initBoard();
                    gameLoop(board);

                } else if (choice == 2) {
                    System.out.println("Give size: ");
                    int size = scanner.nextInt();
                    Board board = new Board(size);
                    board.initBoard();
                    gameLoop(board);
                } else {
                    break;
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter valid numeric value");
            }
        }

    }

    //TODO: implement this with GUI
    public static void printBoard(Board board) {
        for (int i = 0; i < board.getBoard().length * 4 + 1; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int row = 0; row < board.getBoard().length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board.getBoard().length; col++) {
                System.out.print(board.getBoard()[row][col] + " | ");
            }
            System.out.println("");
            for (int j = 0; j < board.getBoard().length * 4 + 1; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }

    //TODO: replace with mouse listener/gui
    public static void placeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        boolean bl = false;

        //prompt until legit move.
        while (!bl) {
            System.out.println("Enter row: ");
            row = scanner.nextInt();
            System.out.println("Enter column: ");
            col = scanner.nextInt();
            if (board.nextMove(row, col)) {
                bl = true;
            }
        }
    }

    /**
     * Create basic game loop.
     *
     * @param board
     */
    public static void gameLoop(Board board) {
        while (!board.isBoardFull() && !board.isWinner()) {

            printBoard(board);
            System.out.println("Player " + board.getMark() + " turn");
            placeMove(board);
            board.changeMark();
        }
        printBoard(board);
        System.out.println("");
        System.out.println("Game has ended!");
    }
}
