package middle;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class middle128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        for (Integer num : set) {
            if (!set.contains(num-1)) {
                //找到最长序列中的最小的那个数，然后计算长度
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum+1)){
                    curNum++;
                    curLen++;
                }

                res = Math.max(res,curLen);
            }
        }

        return res;
    }
}
