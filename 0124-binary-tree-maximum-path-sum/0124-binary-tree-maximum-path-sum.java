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
    int maxSum;

    private int solve(TreeNode root){
        if(root == null) return 0;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        // case 1 koi ek accha h
        int koi_ek_accha_h = Math.max(leftSum , rightSum) + root.val;

        // case 2 
        int only_root_accha_h = root.val;

        // case 3
        int neeche_hi_milgaya_ans = leftSum + rightSum + root.val;

        maxSum = Math.max(maxSum ,
         Math.max(koi_ek_accha_h , 
         Math.max(only_root_accha_h , 
         neeche_hi_milgaya_ans)));

        return Math.max(koi_ek_accha_h , only_root_accha_h);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;

        solve(root);

        return maxSum;
    }
}