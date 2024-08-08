import java.util.HashSet;
import java.util.List;

public class middle139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 排列数
        for (int i = 1; i <= s.length(); i++) {  // 背包
            for (int j = 0; j < i; j++) {  //物品
                String sub = s.substring(j,i);
                if (dp[j] && set.contains(sub)) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
