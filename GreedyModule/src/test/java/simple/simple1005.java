package simple;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class simple1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums).boxed()
                .sorted((o1, o2) -> Integer.compare(Math.abs(o2), Math.abs(o1)))
                .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) nums[nums.length-1] *= -1;

        return Arrays.stream(nums).sum();


    }

}
