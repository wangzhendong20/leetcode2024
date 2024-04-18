package middle;

import java.util.List;

public class middle841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int key, boolean[] visited) {
        visited[key] = true;
        List<Integer> keys = rooms.get(key);
        for (int value : keys) {
            if (visited[value] == false) {
                dfs(rooms,value,visited);
            }
        }
    }

}
