class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> complements = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            final int num = nums[i];
            if (complements.containsKey(num)) {
                return new int[]{complements.get(num), i};
            }

            complements.put(target - num, i);
        }

        return new int[] {-1, -1};
    }
}
