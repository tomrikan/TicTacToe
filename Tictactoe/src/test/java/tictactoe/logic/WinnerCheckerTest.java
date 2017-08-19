/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomi
 */
public class WinnerCheckerTest {
    
    Board board;
    Board board2;
    WinnerChecker wc;
    
    public WinnerCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new Board();
        board2 = new Board(4);
        wc = new WinnerChecker();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isWinnerReturnsTrueIfRowWin() {
        board.initBoard();
        board.nextMove(0, 0);
        board.nextMove(0, 1);
        board.nextMove(0, 2);
        assertEquals(true, wc.isWinner(board));
    }
    
    @Test
    public void isWinnerReturnsTrueIfColWin() {
        board.initBoard();
        board.nextMove(0, 0);
        board.nextMove(1, 0);
        board.nextMove(2, 0);
        assertEquals(true, wc.isWinner(board));
    }
    
    @Test
    public void isWinnerReturnsTrueIfDiagWin() {
        board.initBoard();
        board.nextMove(0, 0);
        board.nextMove(1, 1);
        board.nextMove(2, 2);
        assertEquals(true, wc.isWinner(board));
    }
    
    @Test
    public void isWinnerReturnsTrueIfOtherDiagonal() {
        board.initBoard();
        board.nextMove(0, 2);
        board.nextMove(1, 1);
        board.nextMove(2, 0);
        assertEquals(true, wc.isWinner(board));
    }
    
    @Test
    public void isWinnerReturnsFalseIfNoWin() {
        board.initBoard();
        board.nextMove(0, 0);
        board.nextMove(0, 1);
        board.nextMove(1, 0);
        board.nextMove(1, 1);
        assertEquals(false, wc.isWinner(board));
    }
}
