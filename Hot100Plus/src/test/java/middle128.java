import java.util.HashSet;
import java.util.Map;

public class middle128 {
    /**
     * 使用哈希表去重
     * 找到没有num-1的，这就说明找到了连续数中的最小值
     * 然后+1往大找连续数的个数
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 1;
        for (Integer integer : set) {
            if (!set.contains(integer-1)) {
                int curNum = integer;
                int len = 1;
                while (set.contains(curNum+1)) {
                    curNum++;
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
