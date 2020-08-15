public class NonoverlappingIntervals {

    class Solution {

        public int eraseOverlapIntervals(int[][] intervals) {

            if (intervals.length <= 1) return 0;

            Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

            int eraseOverlapIntervals = 0, prevEnd = Integer.MIN_VALUE;

            for (int[] interval : intervals) {

                if (prevEnd > interval[0]) eraseOverlapIntervals++;
                else prevEnd = interval[1];
            }

            return eraseOverlapIntervals;
        }
    }

}
