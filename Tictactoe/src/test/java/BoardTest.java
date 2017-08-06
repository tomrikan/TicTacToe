/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.Board;

/**
 *
 * @author tomi
 */
public class BoardTest {

    Board board;
    Board board2;

    public BoardTest() {
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorSetsBoardSizeRight() {
        assertEquals(3, board.getBoard().length);
        assertEquals(4, board2.getBoard().length);
    }

    @Test
    public void initializingBoardCorrect() {
        board.initBoard();
        char[][] testTable = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
        assertArrayEquals(testTable,board.getBoard());
    }
}
