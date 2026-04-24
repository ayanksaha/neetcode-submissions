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

        final Deque<Integer> stack = new ArrayDeque<>();
        int size;
        TreeNode node;

        while (!q.isEmpty()) {
            size = q.size();

            for (int i = 1; i <= size; i++) {
                node = q.poll();
                stack.push(node.val);
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            if (!stack.isEmpty()) {
                rightView.add(stack.pop());
                stack.clear();
            }
        }
        return rightView;
    }
}
