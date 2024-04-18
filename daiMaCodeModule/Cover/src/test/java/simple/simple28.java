package simple;

public class simple28 {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }

            if (j == needle.length()-1) {
                return i - needle.length()+1;
            }
        }
        return -1;
    }


    private int[] getNext(String str) {
        int[] next = new int[str.length()];

        int j = -1;
        next[0] = j;
        for (int i = 1; i < str.length(); i++) {
            while (j >= 0 && str.charAt(i) != str.charAt(j+1)) {
                //未匹配
                j = next[j];
            }
            if (str.charAt(i) == str.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
