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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode root, long maxSoFar, long minSoFar) {
        if (Objects.isNull(root)) {
            return true;
        }

        if (!(minSoFar < root.val && root.val < maxSoFar)) {
            return false;
        }

        return isValid(root.left, root.val, minSoFar) && isValid(root.right, maxSoFar, root.val);
    }
}
