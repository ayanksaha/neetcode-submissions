class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> freqs = new HashMap<>();
        final Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (entry1, entry2) -> entry2.getValue() - entry1.getValue()
        );

        for(final int num: nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }

        for(final Map.Entry<Integer, Integer> freq: freqs.entrySet()) {
            maxHeap.offer(freq);
        }

        final int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }
}
