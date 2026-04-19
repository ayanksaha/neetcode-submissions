class Solution {
    public boolean isPalindrome(String s) {
        final String input = sanitize(s.toLowerCase());
        final int n = input.length();

        for(int i=0; i<n; i++) {
            final char fwd = input.charAt(i);
            final char back = input.charAt(n-i-1);

            if(fwd != back) {
                return false;
            }
        }

        return true;
    }

    private String sanitize(String input) {
        final StringBuilder sanitizedInput = new StringBuilder();
        for (final char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sanitizedInput.append(c);
            }
        }
        return sanitizedInput.toString();
    }
}
