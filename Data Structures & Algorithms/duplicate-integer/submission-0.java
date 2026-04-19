class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> uniques = new HashSet<>();
        for(int num: nums) {
            if(uniques.contains(num)) {
                return true;
            }
            uniques.add(num);
        }
        return false; 
    }
}