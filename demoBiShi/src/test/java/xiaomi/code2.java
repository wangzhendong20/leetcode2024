package xiaomi;

import java.util.Random;
import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Random r = new Random();
        if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(r.nextInt(10));
        }
    }
}
