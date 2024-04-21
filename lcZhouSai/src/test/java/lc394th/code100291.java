package lc394th;

public class code100291 {
    public static int numberOfSpecialChars(String word) {
        int count = 0;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        boolean[] hash3 = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                if (hash2[Character.toUpperCase(c) - 'A'] > 0) {
                    hash3[c - 'a'] = true;
                }
                hash1[c - 'a']++;
            } else if (Character.isUpperCase(c)) {
                hash2[c - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (hash1[i] > 0 && hash2[i] > 0 && !hash3[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("AbcbDBdD"));
    }
}
