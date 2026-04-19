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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        final Deque<TreeNode> ancestors = new ArrayDeque<>();
        TreeNode head = root;
        while (Objects.nonNull(head)) {
            ancestors.push(head);
            if (head.val == p.val) {
                break;
            }
            if (head.val < p.val) {
                head = head.right;
            } else {
                head = head.left;
            }
        }

        TreeNode last = null;
        TreeNode ancestor;
        while (!ancestors.isEmpty()) {
            ancestor = ancestors.pop();
            head = ancestor;
            while (Objects.nonNull(head)) {
                if (head.val == q.val) {
                    return ancestor;
                }
                if (head.val < q.val) {
                    head = head.right;
                } else {
                    head = head.left;
                }
                if (head == last) {
                    break;
                }
            }
            last = ancestor;
        }
        
        return null;
    }
}
