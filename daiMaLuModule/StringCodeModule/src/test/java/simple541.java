public class simple541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i+=2*k) {
            if (i + k >= s.length()) {
                reverse(chars,i,s.length()-1);
            } else {
                reverse(chars,i,i+k-1);
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {

        for (; start < end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }

    }
}
