package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middle438 {
    public List<Integer> findAnagrams(String s, String p) {
        //O(n2)
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        p = String.valueOf(pChar);

        List<Integer> ans = new ArrayList<>();
        char[] sChar = s.toCharArray();
        int len = p.length();
        for (int i = 0; i < sChar.length - len + 1; i++) {
            char[] copy = Arrays.copyOfRange(sChar, i, i + len);
            Arrays.sort(copy);
            if (String.valueOf(copy).equals(p)){
                ans.add(i);
            }
        }
        return ans;
    }

    // 将它转变为遍历s的时候一种“消耗品”——当“消耗品”不足，唯一可以做的就是移动左窗口释放一些出来。
    public List<Integer> findAnagrams2(String s, String p) {
        //O(n)  滑动窗口
        int[] p_c = new int[26];
        for(char c : p.toCharArray()) p_c[c - 'a']++;
        int left = 0;
        int right = 0;
        List<Integer> ans = new LinkedList<>();
        while(right < s.length())
        {
            if(p_c[s.charAt(right) - 'a'] > 0){
                p_c[s.charAt(right++) - 'a']--; // 消耗了一个
                if(right - left == p.length()){
                    ans.add(left); // 这里不着急移，p_c不够再移
                }
            } else{
                p_c[s.charAt(left++) - 'a']++;
            }
        }
        return ans;
    }

}
