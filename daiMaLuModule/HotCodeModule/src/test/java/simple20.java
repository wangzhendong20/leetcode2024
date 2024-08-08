import java.util.Deque;
import java.util.LinkedList;

public class simple20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                switch (c) {
                    case '(' : stack.push(')'); break;
                    case '[' : stack.push(']'); break;
                    case '{' : stack.push('}'); break;
                }
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
