import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class hard51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row >= board.length) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isVaild(board,row,col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }

    }

    private boolean isVaild(char[][] board, int row, int col) {

        for (int k = 0; k < row; k++) {
            if (board[k][col] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < board.length ; i--,j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }


}
