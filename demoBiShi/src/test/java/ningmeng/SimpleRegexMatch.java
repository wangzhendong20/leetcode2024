package ningmeng;

import java.util.Scanner;

public class SimpleRegexMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        scanner.nextLine();  // 跳过换行符

        for (int i = 0; i < testCaseCount; i++) {
            String text = scanner.next();
            String pattern = scanner.next();
            boolean result = isMatch(text, pattern);
            System.out.println(result);
        }
    }

    private static boolean isMatch(String text, String pattern) {
        return isMatchHelper(text, pattern, 0, 0);
    }

    private static boolean isMatchHelper(String text, String pattern, int i, int j) {
        // 如果模式到达末尾，看字符串是否也到达末尾
        if (j == pattern.length()) {
            return i == text.length();
        }

        // 判断当前字符是否匹配
        boolean firstMatch = (i < text.length() &&
                (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        // 处理 '*'
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            // 两种情况：
            // 1. 不使用 '*'（跳过 '*' 和前面的字符）
            // 2. 使用 '*'，且当前字符匹配，继续匹配下一个字符
            return isMatchHelper(text, pattern, i, j + 2) ||
                    (firstMatch && isMatchHelper(text, pattern, i + 1, j));
        }

        // 处理 '?'
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '?') {
            // '?'要求前一个字符出现一次或多次，继续匹配
            return (firstMatch && isMatchHelper(text, pattern, i + 1, j + 2)) ||
                    isMatchHelper(text, pattern, i, j + 2);
        }

        // 普通字符或 '.' 的匹配情况
        return firstMatch && isMatchHelper(text, pattern, i + 1, j + 1);
    }
}
