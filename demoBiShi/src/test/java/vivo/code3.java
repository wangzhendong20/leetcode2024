package vivo;

import java.util.Arrays;

public class code3 {
    public boolean canEqualDistribution (int[] prices, int k) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        Arrays.sort(prices);

        int n = prices.length;
        if (prices[n-1] > target) {
            return false;
        }

        boolean[] used = new boolean[n];

        boolean canSucc = canSucceed(prices, 0, target, used, k,0);
        return canSucc;

    }

    private boolean canSucceed(int[] prices, int cur, int sum, boolean[] used, int k, int index) {
        if (k == 1) {
            return true;
        }
        if (cur == sum) {
            return canSucceed(prices, 0, sum, used, k-1, 0);
        }

        for (int i = index; i < prices.length; i++) {
            if (used[i]) continue;
            if (cur + prices[i] > sum) {
                continue;
            }
            used[i] = true;
            cur += prices[i];
            if (canSucceed(prices, cur, sum, used, k, i+1)) {
                return true;
            }
            cur -= prices[i];
            used[i] = false;
            while (i < prices.length-1 && prices[i] == prices[i+1]) {
                i++;
            }
        }

        return false;
    }
}
