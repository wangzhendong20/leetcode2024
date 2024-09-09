package xiaohongshu;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PeakSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Arrays to store lengths of increasing and decreasing sequences
        int[] inc = new int[n];
        int[] dec = new int[n];

        // Calculate the length of the increasing sequence ending at each position
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] <= arr[i - 1]) {
                inc[i] = 1;
            } else {
                inc[i] = inc[i - 1] + 1;
            }
        }

        // Calculate the length of the decreasing sequence starting at each position
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || arr[i] <= arr[i + 1]) {
                dec[i] = 1;
            } else {
                dec[i] = dec[i + 1] + 1;
            }
        }

        // Find the maximum length of the mountain array
        int maxLength = 0;
        for (int i = 1; i < n - 1; i++) {
            if (inc[i] > 1 && dec[i] > 1) { // Valid peak must have both increasing and decreasing parts
                maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
            }
        }

        System.out.println(maxLength);
        
    }
}
