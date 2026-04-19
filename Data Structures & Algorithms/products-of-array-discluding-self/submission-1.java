class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] products = new int[n];

        int prefix = 1;
        products[0] = prefix;
        for (int i = 1; i < n; i++) {
            prefix = prefix * nums[i - 1];
            products[i] = prefix;
        }

        int postFix = 1;
        for (int i = n - 2; i >= 0; i--) {
            postFix = postFix * nums[i + 1];
            products[i] = products[i] * postFix;
        }

        return products;
    }
}  
