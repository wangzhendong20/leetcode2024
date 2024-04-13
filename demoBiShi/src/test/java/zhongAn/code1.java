package zhongAn;

import java.util.Scanner;

public class code1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int Zlen = Integer.parseInt(in.nextLine());
            for (int i = 0; i < Zlen; i++) {
                String[] strings = in.nextLine().split(" ");
                int m = Integer.parseInt(strings[0]);
                int n = Integer.parseInt(strings[1]);
                char[][] chars = new char[m][n];
                for (int j = 0; j < m; j++) {
                    String inStr = in.nextLine();
                    for (int k = 0; k < n; k++) {
                       chars[j][k] = inStr.charAt(k);
                    }
                }


                if (getValid(chars,m,n)){
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }
        }
    }
    private static boolean getValid(char[][] chars, int m, int n) {
        if (m < 3 && n < 3) {
            char flag = chars[0][0];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (chars[i][j] != flag) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] == '.') continue;
                if ((i - 1 < 0 && chars[i+1][j] != '*') || (i + 1 >= m && chars[i-1][j] != '*')) {
                    return false;
                }
                if ((j - 1 < 0 && chars[i][j+1] != '*') || (j + 1 >= n && chars[i][j-1] != '*')) {
                    return false;
                }
                if ((i - 1 >= 0 && i+1 < m && chars[i-1][j] == '*' && chars[i+1][j] == '*')
                    || (i - 1 >= 0 && i+1 < m && chars[i-1][j] != '*' && chars[i+1][j] != '*')) {
                    return false;
                }
                if ((j - 1 >= 0 && j+1 < n && chars[i][j-1] == '*' && chars[i][j+1] == '*')
                    || (j - 1 >= 0 && j+1 < n && chars[i][j-1] != '*' && chars[i][j+1] != '*')) {
                    return false;
                }
                if (i - 1 >= 0 && j - 1 >= 0 && i+1 < m && j+1 < n && chars[i-1][j-1] == '*' && chars[i+1][j+1] == '*'){
                    return false;
                }
            }
        }
        return true;
    }
}
