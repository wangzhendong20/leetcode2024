package simple;

public class simple459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next,s);
        if (next[len-1] != -1 && len % (len - (next[len-1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
