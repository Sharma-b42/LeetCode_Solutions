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
    public int pathSum(TreeNode root, long targetSum) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixCount);
    }

    private int dfs(TreeNode node, long currentSum, long targetSum, Map<Long, Integer> prefixCount) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int count = prefixCount.getOrDefault(currentSum - targetSum, 0);

        prefixCount.merge(currentSum, 1, Integer::sum);

        count += dfs(node.left, currentSum, targetSum, prefixCount);
        count += dfs(node.right, currentSum, targetSum, prefixCount);

        prefixCount.merge(currentSum, -1, Integer::sum);

        return count;
    }
}