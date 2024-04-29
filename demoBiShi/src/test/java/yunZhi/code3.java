package yunZhi;

import java.util.HashMap;
import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            int left = 0;
            int right = 0;
            int[] counts = new int[2];
            // 0是r，1是e
            long ans = 0L;
            while (right < input.length()) {
                if (input.charAt(right) == 'd') {
                    while (left < right) {
                        if (input.charAt(left) == 'r') {
                            counts[0]--;
                        } else if (input.charAt(left) == 'e') {
                            counts[1]--;
                        }

                        left++;

                        if (counts[0] > 0 && counts[1] > 0) {
                            ans++;
                        }
                    }
                    right++;
                    left = right;
                    continue;
                }

                if (input.charAt(right) == 'r') {
                    counts[0]++;
                } else if (input.charAt(right) == 'e') {
                    counts[1]++;
                }

                if (counts[0] > 0 && counts[1] > 0) {
                    ans++;
                }

                right++;
            }

            System.out.println(ans);
        }
    }
}
