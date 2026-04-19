class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freqMap = new HashMap<>();
        for (final int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        final Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(k+1, 
            (a, b) -> a.getValue() - b.getValue()
        );
        for (final Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            heap.offer(entry);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        final int[] result = new int[k];
        int idx = k-1;
        while (!heap.isEmpty()) {
            result[idx--] = heap.poll().getKey();
        }
        return result;
    }
}
