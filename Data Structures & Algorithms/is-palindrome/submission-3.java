class Solution {
    public boolean isPalindrome(String s) {
        final String sanitisedStr = sanitise(s.toLowerCase());
        final int n = sanitisedStr.length();

        for (int i=0; i<n/2; i++) {
            if (sanitisedStr.charAt(i) != sanitisedStr.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    private String sanitise(String s) {
        final StringBuilder result = new StringBuilder();
        
        char c;
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
