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
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> rightView = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        if (Objects.nonNull(root)) {
            q.offer(root);
        }

        int size;
        TreeNode node = null;

        while (!q.isEmpty()) {
            size = q.size();

            for (int i = 1; i <= size; i++) {
                node = q.poll();
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            if (Objects.nonNull(node)) {
                rightView.add(node.val);
                node = null;
            }
        }
        return rightView;
    }
}
