package simple;

public class simple28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next,needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            if (j == needle.length()-1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            //不匹配
            while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
                j = next[j];
            }
            //匹配
            if (s.charAt(i) == s.charAt(j+1)) {
                j++;
            }
            // 将j（前缀的长度）赋给next[i]
            next[i] = j;
        }
    }
}
