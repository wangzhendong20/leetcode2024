public class simple459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(s,next);
        int len = s.length();
        if (next[len - 1] != -1 && len % (len - (next[len-1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    private void getNext(String s, int[] next) {
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
