import java.util.Arrays;
import java.util.Comparator;

public class simple1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o1),Math.abs(o2));
            }
        }).mapToInt(Integer::intValue).toArray();

        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] < 0 && k > 0) {
                nums[i] *= -1;
                k--;
            }
        }

        if (k > 0 && k % 2 == 1) {
            nums[0] *= -1;
        }

        return Arrays.stream(nums).sum();

    }
}
