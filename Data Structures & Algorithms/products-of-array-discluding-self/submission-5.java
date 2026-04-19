class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] prefixProduct = new int[n];
        final int[] postfixProduct = new int[n];

        prefixProduct[0] = nums[0];
        postfixProduct[n-1] = nums[n-1];
        for (int i=1; i<n; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i];
            postfixProduct[n-i-1] = postfixProduct[n-i] * nums[n-i-1]; 
        }

        final int[] result = new int[n];
        result[0] = postfixProduct[1];
        result[n-1] = prefixProduct[n-2];

        for (int i=1; i<n-1; i++) {
            result[i] = prefixProduct[i-1] * postfixProduct[i+1];
        }
        return result;
    }
}  
