package middle;

public class middle541 {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i+= 2*k) {
            if (i+k-1 < s.length()) {
                reverse(charArray,i,i+k-1);
                continue;
            }
            //最后的k的字符
            reverse(charArray,i,charArray.length-1);
        }
        return String.valueOf(charArray);
    }

    private void reverse(char[] chars, int left, int right) {
        for (int i = left,j = right; i < j; i++,j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
}
