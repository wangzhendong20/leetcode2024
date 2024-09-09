package tuyou;

import java.util.HashMap;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int k = Integer.parseInt(in.nextLine());
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('H',1);
            map.put('S',2);
            map.put('D',3);
            map.put('C',4);
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                total = total + map.get(s.charAt(i));
            }

            int winSum = 0;
            for (int i = 0; i < s.length() - k; i++) {
                winSum += map.get(s.charAt(i));
            }
            int min = winSum;
            for (int i = s.length() - k; i < s.length(); i++) {
                winSum = winSum - map.get(s.charAt(i - (s.length() - k))) + map.get(s.charAt(i));
                min = Math.min(min, winSum);
            }

            System.out.println(total - min);
        }
    }
}
