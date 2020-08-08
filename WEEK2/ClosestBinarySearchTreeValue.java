public class ClosestBinarySearchTreeValue {

    /**
     * Q : Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
     *
     *     4
     *    / \
     *   2   5
     *  / \
     * 1   3
     *
     * Input : root = [4,2,5,1,3], target = 3.714286
     *
     * Output: 4
     */
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - ret)) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }
}
