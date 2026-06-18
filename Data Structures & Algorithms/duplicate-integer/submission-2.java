class Solution {
    public boolean hasDuplicate(int[] nums) {
        final int n = nums.length;
        final Set<Integer> visited = new HashSet<>(n);

        for (final int num: nums) {
            if (!visited.add(num)) {
                return true;
            }
        }
        return false;
    }
}