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
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        
        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        final Map<TreeNode, Integer> heightMap = new HashMap<>();
        TreeNode node;

        while (!stack.isEmpty()) {
            node = stack.peek();
            if (Objects.nonNull(node.left) && !heightMap.containsKey(node.left)) {
                stack.push(node.left);
            } else if (Objects.nonNull(node.right) && !heightMap.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int leftHeight = heightMap.getOrDefault(node.left, 0);
                int rightHeight = heightMap.getOrDefault(node.right, 0);
                if (Math.abs(rightHeight - leftHeight) > 1) {
                    return false;
                }
                heightMap.put(node, Math.max(leftHeight, rightHeight) + 1);
            }
        }
        return true;
    }
}
