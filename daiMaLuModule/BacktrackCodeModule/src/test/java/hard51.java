import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class hard51 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, n, 0);
        return res;
    }

    private void backtrack(char[][] board, int n, int row) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                path.addLast(new String(board[row]));
                backtrack(board, n, row + 1);
                board[row][col] = '.';
                path.removeLast();
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row,j=col; i >= 0 && j >=0 ; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row,j=col; i >= 0 && j < board[0].length ; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
