import java.util.ArrayList;
import java.util.List;

public class middle17 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits,0,mapping);
        return res;
    }

    private void backtrack(String digits, int index, String[] mapping) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letter = mapping[digit];
        for (int i = 0; i < letter.length(); i++) {
            path.append(letter.charAt(i));
            backtrack(digits, index+1, mapping);
            path.deleteCharAt(path.length()-1);
        }
    }
}
