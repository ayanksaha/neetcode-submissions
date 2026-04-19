class Solution {
    public boolean isAnagram(String s, String t) {
        final int[] freqMap = new int[26];

        for (final char c: s.toCharArray()) {
            freqMap[c - 'a']++;
        }
        
        for (final char c: t.toCharArray()) {
            freqMap[c - 'a']--;
        }

        for (final int freq: freqMap) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
}
