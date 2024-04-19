package HuaWei.huawei240417;

import java.util.*;

public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());

            String[] s = sc.nextLine().split(" ");

            Deque<String> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (stack.size() < 2) {
                    stack.push(s[i]);
                } else {
                    String temp1 = stack.pop();
                    String temp2 = stack.peek();
                    if (s[i].equals(temp1) && s[i].equals(temp2)) {
                        stack.pop();
                    } else {
                        stack.push(temp1);
                        stack.push(s[i]);
                    }
                }
            }


            List<String> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            Collections.reverse(list);
            int len = list.size();
            int index = 0;
            for (String str : list) {
                if (index != len-1) {
                    System.out.print(str + " ");
                } else {
                    System.out.print(str);
                }
                index++;
            }
            System.out.println();
        }
    }
}
