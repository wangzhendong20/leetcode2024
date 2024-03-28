package HuaWei.hauwei0124;

import java.util.HashMap;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s == null || s.length() == 0) {
                System.out.println(0);
                continue;
            }
            int count = getCount(s);
            System.out.println(count);
        }
    }

    private static int getCount(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('r',1);
        map.put('g',2);
        map.put('b',3);

        char pre = chars[0];
        int len = 1;
        int sum = map.get(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                sum += len;
                len++;
            } else {
                len = 1;
                pre = chars[i];
            }

            sum += map.get(chars[i]);
        }

        return sum;
    }
}
