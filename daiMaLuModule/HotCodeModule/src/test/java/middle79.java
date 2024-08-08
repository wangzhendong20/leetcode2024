public class middle79 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited, int index) {
        if (board[x][y] != word.charAt(index)) return false;
        else if (index == word.length() - 1) return true;

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            if (!visited[newX][newY] && dfs(board, word, newX, newY, visited, index + 1)) return true;
        }

        visited[x][y] = false;

        return false;
    }
}
