package middle;

public class middle34 {
    public int[] searchRange(int[] nums, int target) {

        int leftBorder = getleftBorder(nums,target);
        int rightBorder = getrightBorder(nums,target);

        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1,-1};
        }

        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1,rightBorder - 1};
        }

        return new int[]{-1,-1};

    }


    private int getleftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 计算出来的左边界是不包含target的左边界，左边界同理。
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }

    private int getrightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
