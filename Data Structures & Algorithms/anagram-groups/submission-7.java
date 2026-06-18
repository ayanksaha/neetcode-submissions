class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>(1000);
        Map<Character, Integer> key;
        List<String> value;

        for (final String str : strs) {
            key = generateFrequencyMap(str);
            value = groups.getOrDefault(key, new LinkedList<>());
            value.add(str);
            groups.put(key, value);
        }

        final List<List<String>> result = new LinkedList<>();
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
