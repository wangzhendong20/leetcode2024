import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class middle316 {
    public String removeDuplicateLetters(String s) {

        if (s.length() == 1) return s;

        HashMap<Character,Integer> map = new HashMap<>(); // 统计字符出现次数
        HashSet<Character> set = new HashSet<>(); //记录ans存在的字符

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(s.charAt(i), map.get(c) - 1);

            //如果存在就跳过
            if (set.contains(c)) {
                continue;
            }

            // 如果当前字符小于ans结尾字符，而且ans结尾字符后面还有，就删掉ans结尾字符
            while (!ans.isEmpty() && c < ans.charAt(ans.length() - 1) && map.get(ans.charAt(ans.length() - 1)) > 0) {
                set.remove(ans.charAt(ans.length() - 1));
                ans.deleteCharAt(ans.length() - 1);
            }

            ans.append(c);
            set.add(c);
        }

        return ans.toString();
    }
}
