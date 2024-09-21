package anquan;

import java.util.*;

public class code2 {
    private static int cal(String exp) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operations = new Stack<>();
        StringTokenizer st = new StringTokenizer(exp, " *+", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken().trim();

            if (token.isEmpty()) continue;

            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);
                if (!operations.isEmpty() && operations.peek() == '*') {
                    operations.pop();
                    int topNum = nums.pop();
                    nums.push(topNum * num);
                } else {
                    nums.push(num);
                }
            } else if (token.charAt(0) == '+' || token.charAt(0) == '*') {
                operations.push(token.charAt(0));
            }
        }


        while (!operations.isEmpty()) {
            int num2 = nums.pop();
            int num1 = nums.pop();
            char op = operations.pop();
            if (op == '+') {
                nums.push(num1 + num2);
            }
        }

        return nums.pop();
    }


    private static boolean checkEq(String eq) {
        int pos = eq.indexOf('=');
        String left = eq.substring(0, pos);
        String right = eq.substring(pos + 1);

        int leftVal = cal(left);
        int rightVal = cal(right);

        if (leftVal == rightVal) return true;


        for (int i = 0; i <= left.length(); i++) {
            for (char d = '0'; d <= '9'; d++) {
                String newLeft = left.substring(0, i) + d + left.substring(i);
                if (cal(newLeft) == rightVal) return true;
            }
        }


        for (int i = 0; i <= right.length(); i++) {
            for (char d = '0'; d <= '9'; d++) {
                String newRight = right.substring(0, i) + d + right.substring(i);
                if (cal(left) == cal(newRight)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String eq = sc.nextLine();
            if (checkEq(eq)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
