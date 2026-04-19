class Solution {
    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        final Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        int maxLength = 0;
        for (final int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int currentMaxLength = 1;
                while (numsSet.contains(num + currentMaxLength)) {
                    currentMaxLength++;
                }
                maxLength = Math.max(maxLength, currentMaxLength);
            }
        }

        return maxLength;
    }
}
