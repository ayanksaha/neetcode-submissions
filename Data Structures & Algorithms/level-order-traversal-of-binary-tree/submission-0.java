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
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> levels = new LinkedList<>();
        final Queue<TreeNode> q = new LinkedList<>();
        if (Objects.nonNull(root)) {
            q.offer(root);
        }

        int size;
        TreeNode node;
        List<Integer> level;

        while(!q.isEmpty()) {
            size = q.size();
            level = new LinkedList<>();

            for (int i=1; i<=size; i++) {
                node = q.poll();
                level.add(node.val);
                
                if (Objects.nonNull(node.left)) {
                    q.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    q.offer(node.right);
                }
            }
            levels.add(level);
        }

        return levels;
    }
}
