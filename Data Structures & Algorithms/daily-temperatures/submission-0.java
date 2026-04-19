class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final Deque<Integer> stack = new ArrayDeque<>();
        final int[] result = new int[n];

        for (int currentDay = 0; currentDay < n; currentDay++) {
            final int currentTemp = temperatures[currentDay];

            while(!stack.isEmpty() && (temperatures[stack.peek()] < currentTemp)) {
                final int prevDay = stack.pop();
                result[prevDay] = currentDay - prevDay;
            }
            stack.push(currentDay);
        }

        return result;
    }
}
