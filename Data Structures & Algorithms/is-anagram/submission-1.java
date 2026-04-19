class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqs = new int[26];

        for(char c: s.toCharArray()) {
            freqs[c - 'a']++;
        }

        for(char c: t.toCharArray()) {
            int freq = freqs[c - 'a'];
            if(freq == 0) {
                return false;
            }

            freq--;
            freqs[c - 'a'] = freq;
        }

        for(int i=0; i<26; i++) {
            if(freqs[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
