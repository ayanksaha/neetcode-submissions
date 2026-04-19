class Solution {
    public boolean isValid(String s) {
        final Map<Character, Character> pairs = Map.of('(', ')', '{', '}', '[', ']');
        final Deque<Character> seen = new ArrayDeque<>();
        for (final char current: s.toCharArray()) {
            if(pairs.containsKey(current)) {
                seen.push(current);
            }
            else {
                if(seen.isEmpty() || current != pairs.get(seen.pop())) {
                    return false;
                }
            }
        }
        return seen.isEmpty();
    }
}
