package lc393th;

public class code100256 {
    public static void main(String[] args) {
        String s = "1?:?4";
        System.out.println(findLatestTime(s));
    }

    public static String findLatestTime(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '?') {
            chars[0] = (chars[1] == '?' || chars[1] < '2') ? '1' : '0';
        }
        if (chars[1] == '?') {
            chars[1] = (chars[0] == '1') ? '1' : '9';
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }

}
