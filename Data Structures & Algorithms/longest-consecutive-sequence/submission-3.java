class Solution {
    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        final Set<Integer> numSet = new HashSet<>(n);
        int maxLength = 0;

        for (int num: nums) {
            numSet.add(num);
        }

        int length;
        for (int num: nums) {
            length = 1;
            while (numSet.contains(num+length)) {
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
