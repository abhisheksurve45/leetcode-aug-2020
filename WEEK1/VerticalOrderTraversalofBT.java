public class VerticalOrderTraversalofBT {

    /**
     * Reference :
     * 1. https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/777591/Java-PriorityQueue-and-TreeMap
     * 2. https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/777465/2-Solution-or-Algorithm-with-Steps-or-Helper-Class-and-Custom-Sorting-or-TreeMap-PriorityQueue
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

        private class Point {
            int x;
            int y;
            int val;

            Point(int _x, int _y, int _val) {
                x = _x;
                y = _y;
                val = _val;
            }
        }

        private void dfs(TreeNode root, int x, int y, Queue<Point> q) {

            if (root == null) return;
            q.offer(new Point(x, y, root.val));

            dfs(root.left, x - 1, y - 1, q);
            dfs(root.right, x + 1, y - 1, q);
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {

            if (root == null) new ArrayList();

            Queue<Point> q = new PriorityQueue<Point>((p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val - p2.val : p2.y - p1.y : p1.x - p2.x);

            TreeMap<Integer, List<Integer>> map = new TreeMap<>();

            dfs(root, 0, 0, q);

            while (!q.isEmpty()) {

                Point p = q.poll();

                List<Integer> values = map.getOrDefault(p.x, new ArrayList<>());
                values.add(p.val);
                map.put(p.x, values);

            }

            return new ArrayList<>(map.values());
        }
    }

}
