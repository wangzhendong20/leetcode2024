package lc394th;

public class code100294 {
    public int numberOfSpecialChars(String word) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                hash1[c - 'a']++;
            } else if (Character.isUpperCase(c)) {
                hash2[c - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (hash1[i] > 0 && hash2[i] > 0) {
                count++;
            }
        }

        return count;
    }
}
