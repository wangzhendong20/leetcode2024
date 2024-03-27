package HuaWei.hauwei0124;

import java.util.Scanner;

public class code3 {
    /**
     * todo: 看不懂
     */
    static class BIT {
        int[] trees;

        public BIT(int n) {
            trees = new int[n + 1];
        }

        public void update(int index, int val) {
            int i = index + 1;
            while (i < trees.length) {
                trees[i] += val;
                i += i & -i;
            }
        }

        public int query(int x) {
            int cnt = 0;
            while (x > 0) {
                cnt += trees[x];
                x -= x & -x;
            }
            return cnt;
        }

        public int queryRange(int left, int right) {
            return query(right + 1) - query(left);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stations = new int[n];
        for (int i = 0; i < n; i++) {
            stations[i] = scanner.nextInt();
        }
        int R = scanner.nextInt();
        int k = scanner.nextInt();

        int result = findMaximumRepairTime(stations, n, R, k);
        System.out.println(result);
    }

    public static boolean check(int[] stations, int n, int R, int k, int x) {
        BIT bitTree = new BIT(n);
        for (int i = 0; i < n; i++) {
            bitTree.update(i, stations[i]);
        }

        int rest = k;
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - R);
            int right = Math.min(i + R, n - 1);
            int curSum = bitTree.queryRange(left, right);
            if (curSum <= x) {
                if (rest >= x - curSum) {
                    //todo:应该是right？  bitTree.update(right, x - curSum);
                    bitTree.update(i + R, x - curSum);
                    rest -= x - curSum;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static int findMaximumRepairTime(int[] stations, int n, int R, int k) {
        int l = 0, r = 1000000000;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(stations, n, R, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}


