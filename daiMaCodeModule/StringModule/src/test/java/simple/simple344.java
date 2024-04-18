package simple;

public class simple344 {
    public void reverseString(char[] s) {
        for (int i = 0,j=s.length-1; i < j; i++,j--) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
        }
    }
}
