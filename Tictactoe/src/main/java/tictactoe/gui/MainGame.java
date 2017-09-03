/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui;

import tictactoe.logic.Board;
import tictactoe.ai.AiPlayer;
import javafx.scene.control.TextField;
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
 * Contains Gui and gameloop based on mouse clicks. Could and should be divided
 * into separate controller and view.
 *
 * @author tomi
 */
public class MainGame extends Application {
    
    private Board board;
    private GridPane grid;

    /**
     * Launches GUI.
     *
     * @param args main method stuff.
     */
    public static void main(String[] args) {
        launch(MainGame.class);
    }

    /**
     * Creates GUI.
     *
     * @param window stage's window.
     */
    @Override
    public void start(Stage window) {
        this.board = new Board();
        
        VBox gameMode = new VBox();
        Label modeOne = new Label("1. Player VS Player");
        Label modeTwo = new Label("2. P1 VS LOL-AI");
        TextField chooseMode = new TextField();
        Button modeButton = new Button("Ok");
        Label warningOne = new Label();
        
        gameMode.setSpacing(10);
        gameMode.getChildren().addAll(modeOne, modeTwo, chooseMode, modeButton, warningOne);
        
        Scene modeView = new Scene(gameMode);
        window.setTitle("Tic-Tac-Toe");
        window.setScene(modeView);
        window.show();
        
        modeButton.setOnAction((event) -> {
            int choice;
            String choiceText = chooseMode.getText();
            
            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException e) {
                warningOne.setText("Wrong input.");
                choice = 0;
            }
            if (choice == 1) {
                Label whoseTurn = new Label("Player: " + board.getMark());
                whoseTurn.setFont(Font.font(20));
                grid = new GridPane();
                TextField giveSize = new TextField();
                Label givSais = new Label("Give size (from 3 to 9): ");
                Label warning = new Label();
                Button button = new Button("Ok");
                
                VBox asettelu = new VBox();
                asettelu.setSpacing(10);
                asettelu.getChildren().addAll(givSais, giveSize, button, warning);
                
                Scene nakyma = new Scene(asettelu);
                window.setTitle("Tic-Tac-Toe");
                window.setScene(nakyma);
                window.show();
                
                button.setOnAction((eventOne) -> {
                    int size;
                    String text = giveSize.getText();
                    
                    try {
                        size = Integer.parseInt(text);
                    } catch (NumberFormatException e) {
                        warning.setText("Wrong input.");
                        size = 0;
                    }
                    if (size > 2 && size < 10) {
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
                        window.setTitle("Tic-Tac-Toe");
                        window.setScene(view);
                        window.show();
                    } else {
                        warning.setText("Wrong input.");
                    }
                });
            } else if (choice == 2) {
                this.board.initBoard();
                AiPlayer ai = new AiPlayer();
                
                grid = new GridPane();
                Label whoseTurn = new Label("Player: " + board.getMark());
                whoseTurn.setFont(Font.font(20));
                BorderPane comps = new BorderPane();
                comps.setTop(whoseTurn);
                comps.setCenter(grid);
                
                for (int x = 0; x < board.getBoard().length; x++) {
                    for (int y = 0; y < board.getBoard().length; y++) {
                        grid.add(aiButton(whoseTurn, x, y, ai), x, y);
                    }
                }
                
                Scene view = new Scene(comps);
                window.setTitle("Tic-Tac-Toe");
                window.setScene(view);
                window.show();
            } else {
                warningOne.setText("Wrong input.");
            }
        });
    }

    /**
     * Create buttons and button click based gameloop for ai game.
     *
     * @param text whose turn.
     * @param x button's row.
     * @param y button's column.
     * @param ai cpu.
     * @return button.
     */
    public Button aiButton(Label text, int x, int y, AiPlayer ai) {
        
        Button nappi = new Button(" ");
        nappi.setFont(Font.font("Monospaced", 40));
        
        nappi.setOnAction((event) -> {
            if (!board.isBoardFull() && !board.checkWin()) {
                if (board.nextMove(x, y)) {
                    String mark = Character.toString(board.getMark());
                    nappi.setText(mark);
                    
                    board.changeMark();
                    text.setText("Player: " + board.getMark());
                    
                    if (!board.isBoardFull() && !board.checkWin()) {
                        aiMove(ai);
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
            }
        });
        return nappi;
    }

    /**
     * Makes ai's move displayed on gui.
     *
     * @param ai as aiplayer.
     */
    public void aiMove(AiPlayer ai) {
        int row;
        int col;
        try {
            int[] move = ai.move(board);
            col = move[0];
            row = move[1];
            
        } catch (NullPointerException e) {
            row = 0;
            col = 0;
        }
        for (Node node : grid.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);
            
            if (rowIndex.intValue() == row && columnIndex.intValue() == col) {
                Button b = (Button) node;
                b.setText("O");
                break;
            }
        }
    }

    /**
     * Buttons and button click based gameloop for player vs player mode.
     *
     * @param text whose turn.
     * @param x button's row.
     * @param y button's column.
     * @return button.
     */
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
                if (board.isBoardFull()) {
                    text.setText("It's a tie!");
                }
                if (board.checkWin()) {
                    board.changeMark();
                    text.setText(board.getMark() + " won!");
                }
            }
        });
        return nappi;
    }
}
