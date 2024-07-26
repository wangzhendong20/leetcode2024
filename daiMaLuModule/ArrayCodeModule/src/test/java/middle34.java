public class middle34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        int leftBorder = getLeft(nums, target, left, right);
        int rightBorder = getRight(nums, target, left, right);

        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }

        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }

        return new int[]{-1, -1};
    }


    private int getLeft(int[] nums, int target, int left, int right) {

        int leftBoder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                leftBoder = right;
            }
        }

        return leftBoder;
    }

    private int getRight(int[] nums, int target, int left, int right) {
        int rightBoder = -2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
                rightBoder = left;
            } else {
                right = mid - 1;
            }
        }

        return rightBoder;
    }
}
