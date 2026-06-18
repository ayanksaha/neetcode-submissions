class Solution {
    public boolean isAnagram(String s, String t) {
        final int ns = s.length();
        final int nt = t.length();
        if (ns != nt) {
            return false;
        }

        final short[] freqMap = new short[26];

        for (int i = 0; i < ns; i++) {
            freqMap[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < nt; j++) {
            freqMap[t.charAt(j) - 'a']--;
        }

        for (final short freq : freqMap) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}
