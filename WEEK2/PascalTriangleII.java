public class PascalTriangleII {

    /**
     * Similar to Pascal Triangle : https://leetcode.com/problems/pascals-triangle/
     */
    class Solution {

        public List<Integer> getRow(int numRows) {

            List<List<Integer>> pascal = new ArrayList<>();

            pascal.add(new ArrayList<Integer>() {{
                add(1);
            }});

            if (numRows == 0) pascal.get(0);

            for (int i = 1; i < numRows; i++) {

                List<Integer> row = new ArrayList<>();
                List<Integer> prev = pascal.get(i - 1);

                row.add(1);

                for (int j = 1; j < i; j++) {
                    row.add(prev.get(j) + prev.get(j - 1));
                }

                row.add(1);

                pascal.add(row);

            }

            return pascal.get(pascal.size());
        }
    }
}
