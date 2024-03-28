package xieCheng.xiecheng0313;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(you(s));
        }
    }

    private static String you(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int min = Math.min(map.get('y'),Math.min(map.get('o'), map.get('u')));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append("you");
        }
        map.put('y',map.get('y')-min);
        map.put('o',map.get('o')-min);
        map.put('u',map.get('u')-min);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return String.valueOf(sb);
    }
}
