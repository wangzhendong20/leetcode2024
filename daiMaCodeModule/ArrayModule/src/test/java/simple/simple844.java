package simple;

public class simple844 {
    public static boolean backspaceCompare(String s, String t) {
        s = build(s);
        t = build(t);
        if (s.equals(t)) {
            return true;
        }
        return false;
    }

    private static String build(String str) {
        char[] strChars = str.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < strChars.length; fast++) {
            if (strChars[fast] != '#'){
                strChars[slow++] = strChars[fast];
            } else {
                if (slow > 0) {
                    slow--;
                }
            }
        }
        if (strChars.length == 1) {
            return String.valueOf(strChars);
        }
        return String.valueOf(strChars).substring(0,slow);
    }

    public static void main(String[] args) {
        String s = "xywrrmp", t = "xywrrmu#p";
        System.out.println(backspaceCompare(s,t));
    }
}
