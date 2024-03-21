package XieCheng;

import java.util.HashMap;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = in.nextLine();
            }
            int res = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    res += getCount(strs[i], strs[j]);
                }
            }
            System.out.println(res);
        }

    }


    private static int getCount(String s, String t) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == 'y' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            }
            if (t.charAt(i) == 'y' || t.charAt(i) == 'o' || t.charAt(i) == 'u') {
                map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            }

            if ((s.charAt(i) == 'y' && t.charAt(i) == 'u') || (t.charAt(i) == 'y' && s.charAt(i) == 'u')) {
                flag1 = true;
            }
            if ((s.charAt(i) == 'y' && t.charAt(i) == 'o') || (t.charAt(i) == 'y' && s.charAt(i) == 'o')) {
                flag2 = true;
            }
            if ((s.charAt(i) == 'o' && t.charAt(i) == 'u') || (t.charAt(i) == 'o' && s.charAt(i) == 'u')) {
                flag3 = true;
            }
        }

        if (flag1) {
            if (map.containsKey('o')) {
                ans += map.get('o');
            }
        }
        if (flag2) {
            if (map.containsKey('u')) {
                ans += map.get('u');
            }
        }
        if (flag3) {
            if (map.containsKey('y')) {
                ans += map.get('y');
            }
        }
        return ans;
    }


}
