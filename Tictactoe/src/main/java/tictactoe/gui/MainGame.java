/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui;

import tictactoe.logic.Board;
import java.util.Scanner;
import tictactoe.logic.WinnerChecker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Contains Gui and gameloop.
 *
 * @author tomi
 */
public class MainGame extends Application {

    private Board board;
    //private WinnerChecker wc;

    public static void main(String[] args) {

        launch(MainGame.class);

        /*
        Scanner scanner = new Scanner(System.in);
        WinnerChecker wc = new WinnerChecker();
        
        System.out.println("TIC-TAC-TOE");
        int choice = -1;

        while (choice < 3 || choice > 9) {
            System.out.println("Choose board size. Min 3, max 9. Any other number for quit: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice > 2 && choice < 10) {
                    Board board = new Board(choice);
                    board.initBoard();
                    gameLoop(board, wc);
                    break;
                } else {
                    break;
                }
            } else {
                scanner.nextLine();
                System.out.println("Enter valid numeric value");
            }
        }*/
    }

    /*
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
    }*/

 /*
    public static void placeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int col = -1;
        boolean bl = false;

        //prompt until legit move TODO: try and catch tjsp.
        while (!bl) {

            System.out.println("Enter row: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Enter valid integer.");
                scanner.nextLine();
            }
            row = scanner.nextInt();

            System.out.println("Enter column: ");
            //printing twice for some reason when input is string.
            while (!scanner.hasNextInt()) {
                System.out.println("Enter valid integer.");
                scanner.nextLine();
            }
            col = scanner.nextInt();

            if (board.nextMove(row, col)) {
                bl = true;
            }
        }
    }*/
    /**
     * Create basic game loop.
     *
     * @param board as game board.
     * @param wc as winnerchecker.
     */
    /*
    public static void gameLoop(Board board, WinnerChecker wc) {
        while (!board.isBoardFull() && !wc.isWinner(board)) {

            printBoard(board);
            System.out.println("Player " + board.getMark() + " turn");
            placeMove(board);
            board.changeMark();
        }
        printBoard(board);
        System.out.println("");
        System.out.println("Game has ended!");
    }*/
    @Override
    public void start(Stage window) {
        this.board = new Board();
        Label whoseTurn = new Label("Player: " + board.getMark());
        GridPane grid = new GridPane();
        TextField giveSize = new TextField();
        Label givSais = new Label("Give size (from 3 to 9): ");
        Button button = new Button("Ok");

        VBox asettelu = new VBox();
        asettelu.setSpacing(10);
        asettelu.getChildren().addAll(givSais, giveSize, button);

        Scene nakyma = new Scene(asettelu);

        window.setScene(nakyma);
        window.show();

        button.setOnAction((event) -> {

            String blaa = giveSize.getText();
            int size = Integer.parseInt(blaa);

            this.board.setSize(size);
            this.board.initBoard();

            BorderPane comps = new BorderPane();
            comps.setTop(whoseTurn);
            comps.setCenter(grid);

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    grid.add(button(whoseTurn, x, y), x, y);
                }
            }

            Scene view = new Scene(comps);

            window.setScene(view);
            window.show();

        });
    }

    public Button button(Label text, int x, int y) {

        Button nappi = new Button(" ");
        nappi.setFont(Font.font("Monospaced", 40));

        nappi.setOnAction((event) -> {

            if (!board.isBoardFull() && !board.checkWin()) {

                if (board.nextMove(x, y)) {
                    String mark = Character.toString(board.getMark());
                    nappi.setText(mark);
                    board.changeMark();
                    text.setText("Player: " + board.getMark());
                }
            }

            if (board.isBoardFull()) {
                text.setText("It's a tie!");

            }
            if (board.checkWin()) {
                board.changeMark();
                text.setText(board.getMark() + " won!");

            }

        });
        return nappi;
    }
}
