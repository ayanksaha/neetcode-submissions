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
        for (final Map.Entry<Map<Character, Integer>, List<String>> group : groups.entrySet()) {
            result.add(group.getValue());
        }
        return result;
    }

    final Map<Character, Integer> generateFrequencyMap(final String str) {
        final int n = str.length();
        final Map<Character, Integer> frequencyMap = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        return frequencyMap;
    }
}
