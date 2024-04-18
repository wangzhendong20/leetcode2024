package hard;

import java.util.ArrayList;
import java.util.List;

public class hard52 {
    List<List<String>> res = new ArrayList<>();
    public int totalNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = '.';
            }
        }
        backtracking(n,0,chessboard);
        return res.size();
    }

    private void backtracking(int n, int row, char[][] chessboard) {
        if (row >= n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (Valid(n,row,col,chessboard)) {
                chessboard[row][col] = 'Q';
                row++;
                backtracking(n,row,chessboard);
                row--;
                chessboard[row][col] = '.';
            }
        }

    }

    private boolean Valid(int n, int row, int col, char[][] chessboard) {

        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }

        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (chessboard[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--,j++) {
            if (chessboard[i][j] == 'Q') return false;
        }

        return true;
    }

    private List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessboard) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }
}
