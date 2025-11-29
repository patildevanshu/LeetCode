/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Deserialize helper using array + index pointer
    int idx = 0;

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return build(arr);
    }

    private TreeNode build(String[] arr) {
        // if null marker, move index and return null
        if (arr[idx].equals("#")) {
            idx++;
            return null;
        }

        // create node
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));

        // build left and right
        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));