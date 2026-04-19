class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> visited = new HashSet<>();

        for (int num: nums) {
            if(!visited.add(num)) {
                return true;
            }
        }

        return false;
    }
}