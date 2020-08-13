public class IteratorforCombination {

    /**
     * Explanation : https://leetcode.com/problems/iterator-for-combination/discuss/789455/Java-Algorithm-Explained-or-Queue-Generate-all-Combinations-of-CombinationLength
     */
    class CombinationIterator {

        private Queue<String> queue;

        public CombinationIterator(String characters, int combinationLength) {
            this.queue = new LinkedList<>();
            combinations(characters, 0, "", combinationLength, queue);
        }

        public void combinations(String characters, int start, String soFar, int k, Queue<String> queue) {
            if (k == 0) {
                queue.add(soFar);
                return;
            }

            for (int i = start; i < characters.length(); i++) {
                combinations(characters, i + 1, soFar + characters.charAt(i), k - 1, queue);
            }
        }

        public String next() {
            return this.queue.poll();
        }

        public boolean hasNext() {
            return !this.queue.isEmpty();
        }
    }
}
