package HuaWei;

import java.util.Scanner;

public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String n = in.nextLine();
            String s = n.replaceFirst("0x","");
            int ans = Integer.parseInt(s, 16);
            System.out.println(ans);
            break;
        }
    }
}
