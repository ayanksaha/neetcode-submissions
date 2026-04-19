class KthLargest {
    private final Queue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>(k + 1);
        this.k = k;

        for (final int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
