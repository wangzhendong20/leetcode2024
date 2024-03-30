package meiTuan;

import java.util.*;

public class code4 {
    /**
     * 16.67%  超时
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            char[] charArray = s.toCharArray();
            HashMap<Character,Integer> map = new HashMap<>();
            backtracking(charArray,0,map);

            System.out.println(ans);


        }
    }
    static long ans = 0;
    private static void backtracking(char[] chars, int index, HashMap<Character,Integer> map) {
        if (index == chars.length) {
            return;
        }
        for (int i = index; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
            if (map.size() == 2) {
                int[] equ = new int[2];
                int k = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    equ[k++] = entry.getValue();
                }
                if (equ[0] == equ[1]) {
                    ans++;
                }
            }
            backtracking(chars,i+1,map);
            if (map.get(chars[i])-1 <= 0) {
                map.remove(chars[i]);
            } else {
                map.put(chars[i],map.get(chars[i])-1);
            }
        }
    }
}
