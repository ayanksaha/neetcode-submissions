class Solution {
    public int search(int[] nums, int target) {
        final int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid, num;

        while (left <= right) {
            mid = left + (right - left) / 2;
            num = nums[mid];

            if (num == target) {
                return mid;
            }
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
