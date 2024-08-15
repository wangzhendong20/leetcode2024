package yongyou;

import java.util.Scanner;

public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] maxDurations = new int[n];
        for (int i = 0; i < n; i++) {
//            int max = 0;
//            int count = 0;
            int left = i - 1;
            int right = i + 1;

            while (right < n && arr[right] < arr[i]) {
                right++;
            }

            while (left >= 0 && arr[left] < arr[i]) {
                left--;
            }

//            for (int j = 0; j < n; j++) {
//                if (arr[j] >= arr[i]) {
//                    if (j == i) {
//                        count++;
//                    } else {
//                        count = 0;
//                    }
//                } else {
//                    count++;
//                }
//                max = Math.max(max, count);
//            }
            maxDurations[i] = right - left -1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(maxDurations[i] + " ");
        }
    }
}
