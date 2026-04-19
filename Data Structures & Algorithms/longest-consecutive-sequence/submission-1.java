class Solution {
    public int longestConsecutive(int[] nums) {
        final int n = nums.length;
        final Set<Integer> sortedSet = new TreeSet<>();

        for(int num: nums) {
            sortedSet.add(num);
        }

        int prev = Integer.MAX_VALUE;
        int maxLength = 0;
        int currentMaxLength = 0;
        for(final int num: sortedSet) {
            if(num - prev > 1) {
                maxLength = Math.max(maxLength, currentMaxLength);
                currentMaxLength = 0;
            }
            prev = num;
            currentMaxLength++;
        }

        return Math.max(maxLength, currentMaxLength);
    }
}
