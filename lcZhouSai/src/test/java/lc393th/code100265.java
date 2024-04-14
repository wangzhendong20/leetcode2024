package lc393th;

public class code100265 {
    public static void main(String[] args) {
        int[]nums = {1,7};
        System.out.println(maximumPrimeDifference(nums));
    }
    public static int maximumPrimeDifference(int[] nums) {
        int left = 0, right = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                if (!flag) {
                    left = i;
                    flag = true;
                } else {
                    right = i;
                }
            }
        }
        if (right < left) {
            return 0;
        }
        return right - left;
    }


    private static boolean isPrime(int num) {
        if (num <= 1 ) {
            return false;
        }
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
