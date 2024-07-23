import java.util.HashSet;
import java.util.List;

public class middle139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                String word = s.substring(i,j);
                if (set.contains(word) && dp[i]) {
                    dp[j] = true;
                }
            }
        }

        return dp[s.length()];

    }
}
