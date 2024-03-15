package simple;

public class simple925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        if (name.charAt(0) != typed.charAt(0)) return false;
        int slow = 1;
        int fast = 1;
        for (fast = 1; fast < typed.length() && slow < name.length(); fast++) {
            if (name.charAt(slow) == typed.charAt(fast)) {
                slow++;
            } else if (typed.charAt(fast) != typed.charAt(fast-1)) {
                return false;
            }
        }

        if (slow < name.length()) return false;

        while (fast < typed.length()) {
            if (typed.charAt(fast) != typed.charAt(fast-1)) {
                return false;
            }
            fast++;
        }

        return true;
    }
}
