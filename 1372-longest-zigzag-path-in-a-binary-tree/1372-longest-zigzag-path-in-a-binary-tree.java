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
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return maxLen;
    }

    private void dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }

        maxLen = Math.max(maxLen, Math.max(left, right));

        dfs(node.left, right + 1, 0);
        dfs(node.right, 0, left + 1);
    }
}