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
        char[][] testTable = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        assertArrayEquals(testTable, board.getBoard());
    }

    @Test
    public void initializingBoardForCustomSizeCorrect() {
        board2.initBoard();
        char[][] testTable = {{'-', '-', '-', '-'}, {'-', '-', '-', '-'},
        {'-', '-', '-', '-'}, {'-', '-', '-', '-'},};
        assertArrayEquals(testTable, board2.getBoard());
    }

    @Test
    public void fullBoardReturnsTrue() {
        board.initBoard();
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                board.nextMove(i, j);
            }
        }
        assertEquals(true, board.isBoardFull());
    }

    @Test
    public void emptyBoardReturnsFalse() {
        board.initBoard();
        assertEquals(false, board.isBoardFull());
    }

    @Test
    public void nonFullBoardReturnsFalse() {
        board.initBoard();
        board.nextMove(0, 0);
        assertEquals(false, board.isBoardFull());

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length - 1; j++) {
                board.nextMove(i, j);
            }
        }
        assertEquals(false, board.isBoardFull());
    }

    @Test
    public void playerMarkXInBeginning() {
        char mark = 'X';
        assertEquals(mark, board.getMark());
    }

    @Test
    public void markChangesCorrectly() {
        board.changeMark();
        assertEquals('O', board.getMark());

        board.changeMark();
        assertEquals('X', board.getMark());
    }

    @Test
    public void nextMoveReturnsFalseIfWrongMove() {
        board.initBoard();
        assertEquals(false, board.nextMove(3, 0));

        assertEquals(false, board.nextMove(0, 3));
    }

    @Test
    public void nextMoveReturnsTrueIfCorrectMove() {
        board.initBoard();
        assertEquals(true, board.nextMove(0, 0));

        assertEquals(true, board.nextMove(2, 2));
    }

}
