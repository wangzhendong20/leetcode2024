import java.util.ArrayList;
import java.util.List;

public class middle17 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(digits, 0, map);

        return res;
    }

    private void backtrack(String digits, int startIndex, String[] map) {
        if (sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }

        String word = map[digits.charAt(startIndex) - '0'];

        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            backtrack(digits, startIndex + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
