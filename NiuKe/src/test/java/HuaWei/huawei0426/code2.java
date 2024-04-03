package HuaWei.huawei0426;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] sp1 = in.nextLine().split(" ");
            int start = Integer.parseInt(sp1[0]);
            int end = Integer.parseInt(sp1[1]);

            Deque<Integer> dequeIn = new LinkedList<>();
            Deque<Integer> dequeOut = new LinkedList<>();
            for (int i = start; i <= end; i++) {
                dequeIn.add(i);
            }

            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String[] strings = in.nextLine().split(" ");
                int operation = Integer.parseInt(strings[0]);
                int index = Integer.parseInt(strings[1]);
                if (operation == 1) {
                    for (int j = 0; j < index; j++) {
                        dequeIn.pop();
//                        dequeOut.add(dequeIn.pop());
                    }
                } else if (operation == 2) {
                    dequeIn.remove(index);
//                    dequeOut.add(index);
                } else if (operation == 3) {
                    dequeIn.add(index);
//                    dequeOut.remove(index);
                }
            }
            System.out.println(dequeIn.peek());
        }
    }
}
