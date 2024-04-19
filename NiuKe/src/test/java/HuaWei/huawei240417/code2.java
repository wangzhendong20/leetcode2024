package HuaWei.huawei240417;

import javax.swing.tree.TreeNode;
import java.util.*;


public class code2 {
    static int sum = 0;

    private static void dfs(char cur, List<Character>[] graph, boolean[] visited, int[] degree) {
        if (visited[cur - 'a']) return;

        visited[cur-'a'] = true;
        for (Character character : graph[cur - 'a']) {
            sum += degree[character-'a'];
            dfs(character, graph, visited, degree);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int M = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);
            HashSet<String> set = new HashSet<>();
            List<Character>[] graph = new LinkedList[27];
            for (int i = 0; i < 27; i++) {
                graph[i] = new LinkedList<>();
            }
            int[] degree = new int[27];
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] str = sc.nextLine().split(" ");
                if (!set.contains(str[0] + str[1])) {
                    set.add(str[0] + str[1]);
                    if (str[1].equals("*")) {
                        list.add(str[0].charAt(0));
                        List<Character> characters = graph[str[0].charAt(0) - 'a'];
                        characters.add(str[0].charAt(0));
                        graph[str[0].charAt(0) - 'a'] = characters;
                    } else {
                        List<Character> characters = graph[str[1].charAt(0) - 'a'];
                        characters.add(str[0].charAt(0));
                        graph[str[1].charAt(0) - 'a'] = characters;
                    }
                }
                if (str[2].equals("0")) {
                    degree[str[0].charAt(0) - 'a'] += 5 * Integer.parseInt(str[3]);
                } else {
                    degree[str[0].charAt(0) - 'a'] += 2 * Integer.parseInt(str[3]);
                }
            }
            int ans = 0;
            boolean[] visited = new boolean[27];
            for (int i = 0; i < list.size(); i++) {
                sum = 0;
                dfs(list.get(i), graph, visited, degree);
                if (sum >= M) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

}
