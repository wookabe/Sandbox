package woo.google;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Łukasz on 2017-02-06.
 */
public class SudokuCheckerTest {

    private SudokuChecker sc;

    @Before
    public void setUp() throws Exception {
        sc = new SudokuChecker();
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSolved_null_false() throws Exception {
        assertFalse(sc.isSolved(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSolved_notNullAndNullInside_false() throws Exception {
        final int[][] board = {
                {1, 2, 3}
        };
        assertFalse(sc.isSolved(board));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSolved_NumberLessThanOne_False() throws Exception {
        final int[][] board = {
                {0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSolved_NumberMoreThanNine_False() throws Exception {
        final int[][] board = {
                {10, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test
    public void isSolved_allOnes_False() throws Exception {
        final int[][] board = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test
    public void isSolved_OnlyRowsOK_False() throws Exception {
        final int[][] board = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test
    public void isSolved_OnlyColumnsOK_False() throws Exception {
        final int[][] board = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5, 5, 5, 5, 5},
                {6, 6, 6, 6, 6, 6, 6, 6, 6},
                {7, 7, 7, 7, 7, 7, 7, 7, 7},
                {8, 8, 8, 8, 8, 8, 8, 8, 8},
                {9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test
    public void isSolved_OnlyBlocksOK_False() throws Exception {
        final int[][] board = {
                {1, 4, 7, 1, 4, 7, 1, 4, 7},
                {2, 5, 8, 2, 5, 8, 2, 5, 8},
                {3, 6, 9, 3, 6, 9, 3, 6, 9},
                {1, 4, 7, 1, 4, 7, 1, 4, 7},
                {2, 5, 8, 2, 5, 8, 2, 5, 8},
                {3, 6, 9, 3, 6, 9, 3, 6, 9},
                {1, 4, 7, 1, 4, 7, 1, 4, 7},
                {2, 5, 8, 2, 5, 8, 2, 5, 8},
                {3, 6, 9, 3, 6, 9, 3, 6, 9}
        };

        assertFalse(sc.isSolved(board));
    }

    @Test
    public void isSolved_True() throws Exception {
        final int[][] board = {
                {8, 2, 7, 1, 5, 4, 3, 9, 6},
                {9, 6, 5, 3, 2, 7, 1, 4, 8},
                {3, 4, 1, 6, 8, 9, 7, 5, 2},
                {5, 9, 3, 4, 6, 8, 2, 7, 1},
                {4, 7, 2, 5, 1, 3, 6, 8, 9},
                {6, 1, 8, 9, 7, 2, 4, 3, 5},
                {7, 8, 6, 2, 3, 5, 9, 1, 4},
                {1, 5, 4, 7, 9, 6, 8, 2, 3},
                {2, 3, 9, 8, 4, 1, 5, 6, 7}
        };

        assertTrue(sc.isSolved(board));
    }
}