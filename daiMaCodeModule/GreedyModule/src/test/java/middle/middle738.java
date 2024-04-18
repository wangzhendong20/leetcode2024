package middle;

public class middle738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        int flag = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i-1]) {
                flag = i;
                chars[i-1]--;
            }
        }

        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }

        int res = Integer.valueOf(String.valueOf(chars));
        return res;
    }

}
