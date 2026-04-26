class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final Queue<int[]> heap = new PriorityQueue<>(k + 1,
            Comparator
                .comparingDouble(
                    (int[] point) -> Math.sqrt(point[1] * point[1] + point[0] * point[0]))
                .reversed());
        
        for (final int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        final int[][] result = new int[k][2];

        while (!heap.isEmpty()) {
            final int[] point = heap.poll();
            result[--k] = new int[] {point[0], point[1]};
        }
        return result;
    }
}
