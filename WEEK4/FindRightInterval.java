public class FindRightInterval {

    class Solution {

        public int[] findRightInterval(int[][] intervals) {
            int[] ans = new int[intervals.length];

            for (int i = 0; i < intervals.length; i++) {

                int index = -1;
                int minSoFar = Integer.MAX_VALUE;

                for (int j = 0; j < intervals.length; j++) {
                    if (intervals[j][0] >= intervals[i][1] && minSoFar > intervals[j][0]) {
                        minSoFar = intervals[j][0];
                        index = j;
                    }
                }

                ans[i] = index;
            }

            return ans;
        }
    }

}
