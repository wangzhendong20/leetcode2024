package ningmeng;

import java.util.*;

public class NextHigherMinHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> height = new ArrayList<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            height.add(scanner.nextInt());
        }

        // TreeMap to simulate multiset behavior (key -> count)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int h : height) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for (int h : height) {
            // Remove one occurrence of the element
            map.put(h, map.get(h) - 1);
            if (map.get(h) == 0) {
                map.remove(h);
            }

            // Find the smallest element greater than h
            Integer next = map.higherKey(h);

            if (next != null) {
                System.out.print(next + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }

        scanner.close();
    }
}
