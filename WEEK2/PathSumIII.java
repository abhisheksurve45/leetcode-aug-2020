public class PathSumIII {

    /**
     * Recursive approach
     */
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

        int total = 0;

        private void pathSumHelper(TreeNode root, int sum, int currSum) {
            if (root == null) return;

            currSum += root.val;

            if (sum == currSum) total++;

            pathSumHelper(root.left, sum, currSum);
            pathSumHelper(root.right, sum, currSum);
        }

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return total;

            pathSumHelper(root, sum, 0);
            pathSum(root.left, sum);
            pathSum(root.right, sum);

            return total;
        }
    }


    /**
     * Gain approach using HashMap
     * Link for reference : https://www.youtube.com/watch?v=yyZA4v0x16w
     */
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

        int total = 0;

        private void pathSumHelper(TreeNode root, int target, Map<Integer, Integer> cumulativeSum, int currSum) {
            if (root == null) return;

            currSum += root.val;

            if (cumulativeSum.containsKey(currSum - target)) {
                total += cumulativeSum.get(currSum - target);
            }

            cumulativeSum.put(currSum, cumulativeSum.getOrDefault(currSum, 0) + 1);

            pathSumHelper(root.left, target, cumulativeSum, currSum);
            pathSumHelper(root.right, target, cumulativeSum, currSum);

            cumulativeSum.put(currSum, cumulativeSum.get(currSum) - 1);
        }

        public int pathSum(TreeNode root, int target) {
            if (root == null) return total;

            Map<Integer, Integer> cumulativeSum = new HashMap<>();
            cumulativeSum.put(0, 1);

            pathSumHelper(root, target, cumulativeSum, 0);

            return total;
        }
    }

}
