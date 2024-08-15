package youta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            char[][] graph = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int k = 0; k < s.length(); k++) {
                    graph[i][k] = s.charAt(k);
                }
            }
            boolean[][] visited = new boolean[n][n];
            int maxArea = 0;
            List<Integer> maxCover = new ArrayList<>();
            int maxCoverLen = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == '#' && !visited[i][j]) {
                        area = 1;
                        cover = 0;
                        dfs(graph, i, j, visited);
                        if (area > maxArea) {
                            maxArea = area;
                            maxCover.clear();
                            maxCover.add(cover);
                        } else if (area == maxArea) {
                            maxCover.add(cover);
                        }

                    }
                }
            }

            for (Integer i : maxCover) {
                maxCoverLen = Math.min(maxCoverLen, i);
            }
            System.out.println(maxArea + " " + maxCoverLen);
        }
    }

    static int area = 0;
    static int cover = 0;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static void dfs(char[][] graph, int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= graph.length || newY < 0 || newY >= graph.length || graph[newX][newY] == '.') {
                cover++;
                continue;
            }
            if (graph[newX][newY] == '#' && !visited[newX][newY]) {
                area++;
                dfs(graph, newX, newY, visited);
            }
        }
    }
}
