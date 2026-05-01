/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        final Queue<Integer> heap = new PriorityQueue<>(k + 1, Collections.reverseOrder());
        traverse(root, heap, k);
        return heap.poll();
    }

    private void traverse(TreeNode root, Queue<Integer> heap, int k) {
        if (Objects.isNull(root)) {
            return;
        }

        heap.offer(root.val);
        if (heap.size() > k) {
            heap.poll();
        }
        traverse(root.left, heap, k);
        traverse(root.right, heap, k);
    }
}
