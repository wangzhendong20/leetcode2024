package PinDD;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            char[] charArray = s.toCharArray();
            int ans = n / 3;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (charArray[i] == 'P' && i < n-2) {
                    count += Math.abs(charArray[i+1] - 'D');
                    charArray[i+1] = 'D';
                    count += Math.abs(charArray[i+2] - 'D');
                    charArray[i+2] = 'D';
                } else if (charArray[i] == 'D' && i > 0 && i < n-1 && charArray[i-1] != 'D') {
                    count += Math.abs(charArray[i-1] - 'P');
                    charArray[i-1] = 'P';
                    count += Math.abs(charArray[i+1] - 'D');
                    charArray[i+1] = 'D';
                }
            }
            System.out.println(ans + " " + count);
        }
    }

}
