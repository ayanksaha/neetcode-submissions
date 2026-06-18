class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final int n = strs.length;
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>(n);
        Map<Character, Integer> key;
        List<String> value;
        String str;

        for (int i = 0; i < n; i++) {
            str = strs[i];
            key = generateFrequencyMap(str);
            value = groups.getOrDefault(key, new ArrayList<>());
            value.add(str);
            groups.put(key, value);
        }

        final List<List<String>> result = new ArrayList<>(n);
        for (final List<String> groupVal : groups.values()) {
            result.add(groupVal);
        }
        return result;
    }

    final Map<Character, Integer> generateFrequencyMap(final String str) {
        final Map<Character, Integer> frequencyMap = new HashMap<>(26);
        for (final char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
}
