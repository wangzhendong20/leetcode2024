package middle;

import java.util.LinkedList;

public class middle79 {
    int[][] dir = {
            {1,0},{0,1},{-1,0},{0,-1}
    };
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = backtracking(board,word,i,j,0,visited);
                if (flag) return true;
            }
        }

        return false;
    }

    /**
     * DFS  遇到满足条件就返回
     * @param board
     * @param word
     * @param i
     * @param j
     * @param k
     * @param visited
     * @return
     */
    private boolean backtracking(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        for (int[] dirs : dir) {
            int newx = i + dirs[0];
            int newy = j + dirs[1];
            if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) continue;
            if (!visited[newx][newy]) {
                boolean flag = backtracking(board,word,newx,newy,k+1,visited);
                if (flag) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

}
