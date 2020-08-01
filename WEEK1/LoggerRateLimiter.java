public class LoggerRateLimiter {

    /**
     * Question : https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleEasy/359.html
     */

    public class Logger {

        private Map<String, Integer> messageTimestamps;
        private final int LIMIT = 10;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            this.messageTimestamps =  new HashMap<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!messageTimestamps.containsKey(message)) {
                messageTimestamps.put(message, timestamp);
                return true;
            } else {
                if (timestamp - messageTimestamps.get(message) >= LIMIT) {
                    messageTimestamps.put(message, timestamp);
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
}
