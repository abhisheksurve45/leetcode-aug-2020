public class BestTimetoBuySellStockIII {

    /**
     * Naive approach : https://www.youtube.com/watch?v=0STXF9IXhnA
     */
    class Solution {

        // Denotes persons state in stock market
        private enum State {
            BUY,
            SELL
        }

        private int maxProfitHelper(int[] prices, State state, int index, int k) {

            if (k == 0 || index >= prices.length) return 0;

            if (state.equals(State.BUY)) {

                int buy = maxProfitHelper(prices, State.SELL, index + 1, k) - prices[index];
                int noBuy = maxProfitHelper(prices, State.BUY, index + 1, k);
                return Math.max(buy, noBuy);

            }

            int sell = maxProfitHelper(prices, State.BUY, index + 1, k - 1) + prices[index];
            int noSell = maxProfitHelper(prices, State.SELL, index + 1, k);
            return Math.max(sell, noSell);

        }

        public int maxProfit(int[] prices) {

            if (prices.length == 0) return 0;
            return maxProfitHelper(prices, State.BUY, 0, 2);
        }
    }


    /**
     * Explanation : https://www.youtube.com/watch?v=GFa9xlgZcEI
     */
    class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length == 0) return 0;

            int b1 = Integer.MAX_VALUE, b2 = Integer.MAX_VALUE, p1 = 0, p2 = 0;

            for (int price : prices) {
                b1 = Math.min(b1, price);
                p1 = Math.max(p1, price - b1);
                b2 = Math.min(b2, price - p1);
                p2 = Math.max(p2, price - b2);
            }

            return p2;
        }
    }
}
