class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> visited = new HashMap<>();
        final int len = nums.length;

        for(int i=0; i<len; i++) {
            int num = nums[i];
            int complement = target - num;
            if(visited.containsKey(complement)) {
                return new int[]{visited.get(complement), i};
            }

            visited.put(num, i);
        }

        return null;
    }
}
