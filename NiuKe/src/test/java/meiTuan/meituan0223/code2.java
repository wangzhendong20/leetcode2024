package meiTuan.meituan0223;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            int ans = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
