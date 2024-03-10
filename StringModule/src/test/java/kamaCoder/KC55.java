package kamaCoder;

public class KC55 {
    public static void rightReverse(String s, int k) {
        char[] ch = s.toCharArray();
        reverse(ch,0, ch.length-k-1);
        reverse(ch, ch.length - k, ch.length);
        reverse(ch,0,ch.length-1);
    }

    private static void reverse(char[] ch, int start, int end) {
        for (int i = start,j = end; i < j ; i++,j--) {
            char tmp = ch[i];
            ch[j] = ch[i];
            ch[i] = tmp;
        }
    }
}
