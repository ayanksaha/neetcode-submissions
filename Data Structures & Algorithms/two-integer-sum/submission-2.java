class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        final Map<Integer, Integer> complements = new HashMap<>(n);
        int complement, complementIdx;

        for (int i = 0; i < n; i++) {
            complement = target - nums[i];
            complementIdx = complements.getOrDefault(complement, -1);

            if (complementIdx != -1) {
                return new int[] {complementIdx, i};
            }

            complements.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
