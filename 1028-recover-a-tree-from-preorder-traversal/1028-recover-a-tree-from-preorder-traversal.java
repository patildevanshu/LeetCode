/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String s) {
        //Using the Map to store the dashCount with its corresponding TreeNode.
        Map<Integer, TreeNode> map = new HashMap<>();
        int num = 0;
        int idx = 0;
        // while loop to handle multiple digit Integer value.
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            num = (num * 10) + (s.charAt(idx) - '0');
            idx++;
        }
        map.put(0, new TreeNode(num));
        //Calling the function with the idx of the first dash after the rootNode.
        helper(idx, s, map);
        //returning the root
        return map.get(0);
    }

    public static void helper(int idx, String s, Map<Integer, TreeNode> map) {
        //While loop to iterate the entire length of the string.
        while (idx < s.length()) {
            //While loop to count the no. of. dashes.
            int dash = 0;
            while (idx < s.length() && s.charAt(idx) == '-') {
                dash++;
                idx++;
            }
            //While loop to handle multiple digit Integer values.
            int num = 0;
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                num = (num * 10) + (s.charAt(idx) - '0');
                idx++;
            }
            //Getting the parent node from the map.
            TreeNode node = map.get(dash - 1);
            //Making the obtained number to a TreeNode
            TreeNode val = new TreeNode(num);
            //Storing the dashCount with its corresponding TreeNode
            map.put(dash, val);
            //Checking the leftNode of the parent is empty to add the current node if so then stroing it on the right node.
            if (node.left == null) {
                node.left = val;
            } else {
                node.right = val;
            }
        }
    }
}