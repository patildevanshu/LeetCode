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
class FindElements {
    private HashSet<Integer> set;
    private void addElements(TreeNode root, int x){
        // if(root == null)    
        root.val = x;
        set.add(x);
        if(root.left != null)   addElements(root.left, 2*x + 1);
        if(root.right != null)  addElements(root.right, 2*x +2);
        return;
    }
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        addElements(root, 0);
      
        }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */