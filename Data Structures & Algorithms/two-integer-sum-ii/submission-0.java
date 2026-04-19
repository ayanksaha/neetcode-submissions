class Solution {
    public int[] twoSum(int[] numbers, int target) {
        final int n = numbers.length;

        int left = 0;
        for (int right = n-1; right >= 0; right--) {
            int complement = target - numbers[right];

            while ((numbers[left] <= complement) && (left < right)) {
                if(numbers[left] == complement) {
                    return new int[] { left + 1, right + 1};
                }

                left++;
            }

            if(left >= right) {
                break;
            }
        }

        return new int[] { -1, -1 };
    }
}
