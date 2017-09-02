/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.ai;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.logic.Board;

/**
 *
 * @author tomi
 */
public class AiPlayerTest {
    
    AiPlayer ai;
    Board board;
    
    public AiPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.ai = new AiPlayer();
        this.board = new Board();
        board.initBoard();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void moveReturnsCorrectMoveWhenBoardEmpty() {
        int[] array = {1, 1};
        assertArrayEquals(array, ai.move(board));
    }
    
    @Test
    public void MoveReturnsCorrectWhenBoardNotEmpty() {
        board.nextMove(1, 1);
        int[] array = {0,0};
        assertArrayEquals(array, ai.move(board));
    }
}
