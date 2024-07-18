import java.util.ArrayList;
import java.util.List;

public class middle17 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return res;
        }

        String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(digits,numString,0);

        return res;
    }

    private void backtrack(String digits, String[] numString, int startIndex) {
        if (sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }
        String s = numString[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(digits,numString,startIndex+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
