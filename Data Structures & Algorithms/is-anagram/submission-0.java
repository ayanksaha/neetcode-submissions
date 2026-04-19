class Solution {
    public boolean isAnagram(String s, String t) {
        final Map<Character, Integer> freqs = new HashMap<>();

        for(char c: s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
            int freq = freqs.getOrDefault(c, 0);
            if(freq == 0) {
                return false;
            }

            freq--;
            freqs.put(c, freq);
        }

        for(Map.Entry<Character, Integer> freq: freqs.entrySet()) {
            if(freq.getValue() > 0) {
                return false;
            }
        }

        return true;
    }
}
