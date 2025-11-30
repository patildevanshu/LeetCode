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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            // Search in left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Search in right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            else {
                // Find inorder successor (minimum in right subtree)
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                // Delete successor node
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    // Helper to find minimum value node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
