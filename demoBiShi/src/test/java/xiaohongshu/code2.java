package xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long[] newArr = new long[n];
        for (int i = 1; i <= n; i++) {
            newArr[i-1] = (long) i * (n - i + 1);
        }

        Arrays.sort(newArr);

        long minSun = 0L;
        for (int i = 0; i < n; i++) {
            minSun += arr[i] * newArr[n - 1 - i];
        }

        System.out.println(minSun);


    }
}
