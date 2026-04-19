class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final int len = strs.length;
        final Map<String, List<String>> groups = new HashMap<>();

        for(final String str: strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String key = new String(chars);

            final List<String> group = groups.getOrDefault(key, new ArrayList<>());
            group.add(str);
            groups.put(key, group);
        }

        return new ArrayList<>(groups.values());
    }
}
