package woo.google;

/**
 * Created by Łukasz on 2017-02-06.
 */
//Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.
//
//        Implement a sudoku solution verifier function.  The rules for sudoku is this:
//
//        You have a 9 by 9 board.  This board is divided into nine rows, nine columns, and nine 3x3 blocks.  In a solved puzzle, every row, every column, and every 3x3 block has to contain each of the digits from 1 to 9.  This is an example of a solved puzzle:
//        248|395|716
//        571|628|349
//        936|741|582
//        ---+---+---
//        682|539|174
//        359|174|628
//        714|862|953
//        ---+---+---
//        863|417|295
//        195|286|437
//        427|953|861

public class SudokuChecker {

    public boolean isSolved(int[][] board) {
        validateInput(board);

        boolean[][] rows = init();
        boolean[][] columns = init();
        boolean[][] blocks = init();

        setMarkers(board, rows, columns, blocks);
        return checkMarkers(rows, columns, blocks);
    }

    private void setMarkers(int[][] board, boolean[][] rows, boolean[][] columns, boolean[][] blocks) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                rows[i][board[i][j] - 1] = true;
                columns[j][board[i][j] - 1] = true;
                blocks[i / 3 + (j / 3) * 3][board[i][j] - 1] = true;
            }
        }
    }

    private boolean checkMarkers(boolean[][] rows, boolean[][] columns, boolean[][] blocks) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (!rows[i][j] || !columns[i][j] || !blocks[i][j]) {
                    return false;
                }
        }
        return true;
    }

    private boolean[][] init() {
        boolean[][] matrix = new boolean[9][];
        for (int i = 0; i < 9; i++) {
            matrix[i] = new boolean[9];
        }
        return matrix;
    }

    private void validateInput(int[][] board) {
        if (board == null || board.length != 9)
            throw new IllegalArgumentException("board cannot bu null or have less columns than 9");
        assert board != null && board.length == 9;

        for (int i = 0; i < 9; i++) {
            if (board[i] == null || board[i].length != 9)
                throw new IllegalArgumentException("board cannot have less rows than 9: i=" + i);
            assert board[i] != null && board[i].length == 9;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] < 1 || board[i][j] > 9)
                    throw new IllegalArgumentException("values must be between 1 and 9: " + board[i][j]);
            }
        }
    }
}

