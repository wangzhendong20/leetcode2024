package HuaWei.hauwei1129;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class code3 {
    static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = dfs(1, n, k);
        System.out.println(result);
    }

    /**
     * 记忆化搜索
     * @param l
     * @param r
     * @param height  高度
     * @return
     */
    public static int dfs(int l, int r, int height) {
        if (l > r) return 1;  //终止
        if (height == 1) { // 当前只可以填一个节点
            if (l == r) return 1;
            return 0;
        }
        if (l == r) return 1;

        String key = l + "-" + r + "-" + height;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int ans = 0;
        for (int root = l; root <= r; root++) {
            // 把每一个节点都作为root进行计算
            ans += dfs(l, root - 1, height - 1) * dfs(root + 1, r, height - 1);
        }

        cache.put(key, ans);
        return ans;
    }

}
