public class middle151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = removeSpaces(chars);
        sb.reverse();
        reverseEachWord(sb);
        return sb.toString();
    }


    public void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }

            reverseString(sb, start, end-1);
            start = end + 1;
            end = start + 1;
        }
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private StringBuilder removeSpaces(char[] chars) {
        int start = 0;
        int end = chars.length - 1;

        while (chars[start] == ' ') start++;
        while (chars[end] == ' ') end--;

        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (i > start && chars[i] == ' ' && chars[i-1] == chars[i]) {
                continue;
            }else {
                sb.append(chars[i]);
            }
        }

        return sb;
    }
}
