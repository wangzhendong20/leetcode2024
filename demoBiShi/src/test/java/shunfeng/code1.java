package shunfeng;

import java.util.Scanner;

public class code1 {
    // 判断是否为小驼峰命名法
    private static boolean isCamelCase(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (name.contains("_")) {
            return false; // camelCase 不应该包含下划线
        }
        return Character.isLowerCase(name.charAt(0));
    }

    // 判断是否为下划线命名法
    private static boolean isSnakeCase(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (name.charAt(name.length() - 1) == '_') {
            return false;
        }
        return name.matches("[a-z0-9_]+") && !name.contains("__");
    }

    // 将小驼峰命名法转换为下划线命名法
    private static String camelToSnake(String name) {
        StringBuilder result = new StringBuilder();
        for (char c : name.toCharArray()) {
            if (Character.isUpperCase(c)) {
                if (result.length() > 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            String functionName = scanner.nextLine().trim();
            if (isCamelCase(functionName)) {
                System.out.println(camelToSnake(functionName));
            } else if (isSnakeCase(functionName)) {
                System.out.println(functionName);
            } else {
                System.out.println("indistinct");
            }
        }

        scanner.close();
    }
}
