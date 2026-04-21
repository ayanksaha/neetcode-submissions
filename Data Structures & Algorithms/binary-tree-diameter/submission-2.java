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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        final Map<TreeNode, Map.Entry<Integer, Integer>> map = new HashMap<>();
        map.put(null, Map.entry(0, 0));

        TreeNode node;

        while (!stack.isEmpty()) {
            node = stack.peek();
            if (Objects.nonNull(node.left) && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (Objects.nonNull(node.right) && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();
                final Map.Entry<Integer, Integer> leftData = map.get(node.left);
                final Map.Entry<Integer, Integer> rightData = map.get(node.right);

                final int leftHeight = leftData.getKey(), leftDiameter = leftData.getValue();
                final int rightHeight = rightData.getKey(), rightDiameter = rightData.getValue();

                final int height = 1 + Math.max(leftHeight, rightHeight);
                final int diameter =
                    Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));

                map.put(node, Map.entry(height, diameter));
            }
        }

        return map.get(root).getValue();
    }
}
