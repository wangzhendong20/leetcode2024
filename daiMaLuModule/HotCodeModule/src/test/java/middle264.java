import java.util.HashSet;
import java.util.PriorityQueue;

public class middle264 {
    /**
     * 每个丑数都可以用较小的丑数乘以2，3，5得到，因此可以用优先队列来维护
     * 小顶堆维护丑数，弹出的第n个数就是第n个丑数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long start = 1L;
        pq.add(start);
        set.add(start);
        long ans = 0L;

        for (int i = 0; i < n; i++) {
            ans = pq.poll();
            long tmp1 = ans * 2;
            long tmp2 = ans * 3;
            long tmp3 = ans * 5;
            if (!set.contains(tmp1)) {
                pq.add(tmp1);
                set.add(tmp1);
            }
            if (!set.contains(tmp2)) {
                pq.add(tmp2);
                set.add(tmp2);
            }
            if (!set.contains(tmp3)) {
                pq.add(tmp3);
                set.add(tmp3);
            }

        }
        return (int) ans;
    }


    /**
     * 动态规划
     * dp[i]定义： dp[i]表示第i个丑数
     * 递推公式： dp[i] = min(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5)
     * 初始化：dp[1] = 1
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));

            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;
        }

        return dp[n];
    }
}
