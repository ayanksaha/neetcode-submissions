class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;
        final Map<Integer, Integer> complements = new HashMap<>(n);

        int complement, num;
        for (int i=0; i<n; i++) {
            num = numbers[i];
            complement = target - num;
            if (complements.containsKey(num)) {
                return new int[] { complements.get(num), i+1 };
            }
            complements.put(complement, i+1);
        }
        return new int[] { -1, -1 };
    }
}
