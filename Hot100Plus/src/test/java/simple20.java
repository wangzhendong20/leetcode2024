import java.util.Deque;
import java.util.LinkedList;

public class simple20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')');break;
                case '{': stack.push('}');break;
                case '[': stack.push(']');break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
