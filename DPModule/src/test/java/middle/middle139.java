package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class middle139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {  //遍历背包
            for (int i = 0; i < j; i++) {  //遍历物品
                String word = s.substring(i,j);
                if (set.contains(word) && dp[i]) {
                    dp[j] = true;
                }
            }
        }

        for (boolean b : dp) {
            System.out.print(b + " ");
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(s,wordDict));
    }
}
