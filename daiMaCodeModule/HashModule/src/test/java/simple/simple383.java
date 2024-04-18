package simple;

public class simple383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            records[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a']--;
        }

        for (int record : records) {
            if (record > 0) {
                return false;
            }
        }
        return true;
    }
}
