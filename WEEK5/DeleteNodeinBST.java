public class DeleteNodeinBST {
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
        public TreeNode deleteNode(TreeNode root, int key) {

            if (root == null) return root;

            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {

                if (root.left != null && root.right != null) {

                    TreeNode maxFromLeft = findMaxFromBST(root.left);

                    root.val = maxFromLeft.val;

                    root.left = deleteNode(root.left, maxFromLeft.val);

                } else if (root.left != null) {
                    return root.left;
                } else {
                    return root.right;
                }
            }

            return root;
        }


        private static TreeNode findMaxFromBST(TreeNode root) {
            while (root.right != null) root = root.right;
            return root;
        }
    }
}
