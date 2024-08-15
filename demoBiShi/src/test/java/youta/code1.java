package youta;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                int has = in.nextInt();
                map.put(arr[i], has);
            }

            Arrays.sort(arr);

            int maxlen = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                if (map.get(arr[i]) != map.get(arr[i-1])) {
                    maxlen = Math.min(maxlen, arr[i] - arr[i-1]);
                }
            }

            int ans = 0;
            int left = 0;
            int pre = -1;
            while (left < n) {
                if (map.get(arr[left]) == 1) {
                    if (pre == -1 || arr[left] - arr[pre] >= maxlen) {
                        ans++;
                        pre = left;
                    } else {
                        pre = left;
                    }
                }
                left++;
            }

            System.out.println(ans);

        }
    }
}
