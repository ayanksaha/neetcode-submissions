class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>(26);

        for (final String str: strs) {
            final Map<Character, Integer> key = formFrequencyMap(str);
            List<String> value = groups.getOrDefault(key, new LinkedList<>());
            value.add(str);
            groups.put(key, value);
        }

        final List<List<String>> result = new LinkedList<>();
        for (final List<String> item: groups.values()) {
            result.add(item);
        }
        
        return result;
    }

    private Map<Character, Integer> formFrequencyMap(String str) {
        final Map<Character, Integer> freqMap = new HashMap<>(26);
        
        for (final char c: str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return freqMap;
    }
}
