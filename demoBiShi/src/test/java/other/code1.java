package other;

import java.util.Scanner;

public class code1 {
    /**
     * 给定数组s，表示同学的体重，一艘船最多承载两人，最大称重L，求最小船只数。
     * 划船到对岸所需要的时间。一艘船最多承载两人，时间取大的。只有一艘船，时长最短。 1 3 7 99 100
     * s[i] <= L
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int count = 0;

        int left = 0;
        int right = n - 1;
        while(left <= right) {
            if(arr[left] + arr[right] <= L) {
                left++;
            }
            right--;
            count++;
        }

        System.out.println(count);


    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while(left < right) {
            while(right > left && arr[right] > pivot) {
                right--;
            }

            arr[left] = arr[right];
            while(left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        sort(arr,start,pivot-1);
        sort(arr,pivot+1,end);
    }

}
