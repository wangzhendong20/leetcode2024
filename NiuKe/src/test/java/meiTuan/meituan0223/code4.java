package meiTuan.meituan0223;

import java.util.*;

public class code4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String[] ins = scanner.nextLine().split("\\)");

        List<String[]> strings = new ArrayList<>();
        for (String i : ins) {
            if (!i.isEmpty()) {
                int index = i.indexOf("(");
                strings.add(new String[]{String.valueOf(i.charAt(0)), i.substring(index + 1)});
            }
        }

        Set<String> types = new HashSet<>();
        int cur_length = 0;
        int ans = 0;
        for (String[] str : strings) {
            String string = str[0];
            int cnt = Integer.parseInt(str[1]);
            types.add(string);
            if (cnt >= Math.ceil(k / (double) types.size()) - cur_length) {
                ans++;
                cur_length = cnt - (int) (Math.ceil(k / (double) types.size()) - cur_length);
                if (cur_length >= k) {
                    ans += cur_length / k;
                    if (cur_length % k == 0) {
                        types.clear();
                        cur_length = 0;
                    } else {
                        types.clear();
                        types.add(string);
                        cur_length = cur_length % k;
                    }
                } else {
                    types.clear();
                    if (cur_length != 0) types.add(string);
                }
            } else {
                cur_length += cnt;
            }
        }

        if (ans == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
