package simple;

public class simple541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=i+2*k) {
            if (i + k <= chars.length) {
                //剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
                reverse(chars,i,i+k);
                continue;
            }
            reverse(chars,i,chars.length);
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] ch, int begin, int end) {
        for (int i = begin,j=end-1; i < j; i++,j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }
}
