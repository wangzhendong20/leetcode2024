public class middle547 {

    /**
     * DFS模板题
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int x, boolean[] visited) {

        if (visited[x]) return;
        visited[x] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (x == i) continue;
            if (isConnected[x][i] == 1 && !visited[i]) {
                dfs(isConnected, i ,visited);
            }
        }

    }
}
