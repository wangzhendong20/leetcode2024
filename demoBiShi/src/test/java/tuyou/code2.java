package tuyou;

import java.util.HashMap;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            HashMap<Character, Integer> map = new HashMap<>();
            int maxLen = 0;
            int maxCount = 0;
            int left = 0;

            for (int right = 0; right < n; right++) {
                char ch = s.charAt(right);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxCount = Math.max(maxCount, map.get(ch));

                while((right - left + 1) - maxCount > k) {
                    char leftCh = s.charAt(left);
                    map.put(leftCh, map.get(leftCh) - 1);
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }

            System.out.println(maxLen);


        }
    }
}
