public class simple28 {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(needle,next);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }

            if (j == needle.length()-1) {
                return  (i - needle.length() + 1);
            }
        }

        return -1;
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
