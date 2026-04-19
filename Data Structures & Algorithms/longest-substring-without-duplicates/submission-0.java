class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        final Integer[] indices = new Integer[128];

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            final char current = s.charAt(right);
            final Integer prev = indices[current];
            if (Objects.nonNull(prev) && (left <= prev)) {
                left = prev + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            indices[current] = right;
        }

        return maxLength;
    }
}
