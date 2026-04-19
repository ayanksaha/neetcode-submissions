class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final int n = nums.length;
        final List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int left = 0; left < n; left++) {
            if (nums[left] > 0) {
                break;
            }

            if ((left > 0) && (nums[left] == nums[left - 1])) {
                continue;
            }

            int mid = left + 1;
            int right = n - 1;

            while (mid < right) {
                final int triplet = nums[left] + nums[mid] + nums[right];

                if (triplet == 0) {
                    result.add(List.of(nums[left], nums[mid], nums[right]));
                    mid++;

                    while((mid < right) && (nums[mid] == nums[mid - 1])) {
                        mid++;
                    }
                } else if (triplet > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        return result;
    }
}
