package rongyao;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine().trim();
            String line = in.nextLine();
            String newStr = s.replaceAll("[ \t]","");
            int ans = 0;
            for (int i = 0; i < newStr.length() - line.length() + 1; i++) {
                if (newStr.substring(i,i+line.length()).equals(line)) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
