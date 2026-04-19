class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] products = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            products[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postFix = 1;
        for (int i = n - 1; i >= 0; i--) {
            products[i] = products[i] * postFix;
            postFix = postFix * nums[i];
        }

        return products;
    }
}  
