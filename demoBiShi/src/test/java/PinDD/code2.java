package PinDD;

import java.util.Scanner;

public class code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int start = 2; start <= n; start++) {
                long temp = 0;
                int index = 0;
                for (int end = start; end <= n; end++) {
                    long temp2 = 0;
                    for (int j = index; j < end; j++) {
                        if (j == index) {
                            temp2 += arr[j];
                            continue;
                        }
                        if (arr[j] != arr[j-1]) {
                            temp2 += arr[j];
                        } else {
                            temp2 = 0;
                            break;
                        }
                    }
                    temp += temp2;
                    index++;
                }
                sum += temp;
            }

            System.out.println(sum % (10000007));
        }
    }
}
