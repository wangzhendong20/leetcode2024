import java.util.ArrayList;
import java.util.List;

public class middle386 {
    /**
     * 递归实现dfs
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 1; i < 10; i++) {
            //1到9开头
            dfs(n, i, res);
        }

        return res;
    }

    private void dfs (int n, int i, List<Integer> res) {
        if (i > n) {
            return;
        }
        res.add(i);
        for (int j = 0; j < 10; j++) {
            // 每次乘以10
            dfs(n, i*10+j, res);
        }

    }

    /**
     * 前缀树+dfs
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int cur = 1;

        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur % 10 == 9 || cur >= n) {
                    // 枚举到当前前缀的最深处了，需要回到上一层并到下一个同层节点
                    cur /= 10;
                }
                cur++;
            }
        }

        return res;
    }
}
