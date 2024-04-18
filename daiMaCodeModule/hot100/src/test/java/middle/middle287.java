package middle;

public class middle287 {
    /**
     * 快慢指针 -> 类似环状链表
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = 0;
        while (slow != fast) {
             slow = nums[slow];
             fast = nums[fast];
        }
        return slow;
    }
}
