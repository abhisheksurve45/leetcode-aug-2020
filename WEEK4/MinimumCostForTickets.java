public class MinimumCostForTickets {

    class Solution {

        private static int mincostTicketsHelper(int[] days, int[] costs, int index, int[] dp) {

            if (index >= days.length) return 0;

            if (dp[index] > 0) return dp[index];

            // Process for 1 day pass
            int min1 = costs[0] + mincostTicketsHelper(days, costs, index + 1, dp);

            // Process for 7 day pass
            int k = index;
            for (; k < days.length; k++) {
                if (days[k] >= days[index] + 7) break;
            }
            int min7 = costs[1] + mincostTicketsHelper(days, costs, k, dp);

            // Process for 30 day pass
            for (; k < days.length; k++) {
                if (days[k] >= days[index] + 30) break;
            }
            int min30 = costs[2] + mincostTicketsHelper(days, costs, k, dp);

            return dp[index] = Math.min(min1, Math.min(min7, min30));
        }


        public int mincostTickets(int[] days, int[] costs) {
            return mincostTicketsHelper(days, costs, 0, new int[days.length]);
        }
    }
}
