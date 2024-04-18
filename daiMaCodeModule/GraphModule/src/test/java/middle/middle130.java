package middle;

import java.util.Deque;
import java.util.LinkedList;

public class middle130 {
    int[][] dir = {
            {1,0},{-1,0},{0,1},{0,-1}
    };
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') bfs(board,i,0);
            if (board[i][n-1] == 'O') bfs(board,i,n-1);
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') bfs(board,0,i);
            if (board[m-1][i] == 'O') bfs(board,m-1,i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void bfs(char[][] board, int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{x,y});
        board[x][y] = 'A';

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int curx = cur[0];
            int cury = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][0];
                int nexty = cury + dir[i][1];
                if (nextx < 0 || nextx >= board.length || nexty < 0 || nexty >= board[0].length) continue;
                if (board[nextx][nexty] == 'O') {
                    deque.offer(new int[]{nextx,nexty});
                    board[nextx][nexty] = 'A';
                }
            }
        }
    }
}
