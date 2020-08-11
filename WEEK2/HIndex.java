public class HIndex {

    /**
     * Sorting approach
     */
    class Solution {

        public int hIndex(int[] citations) {

            Arrays.sort(citations);
            int n = citations.length;

            for (int i = 0; i < n; i++) {

                if (citations[i] >= n - i) {
                    return (n - i);
                }

            }

            return 0;

        }
    }

    /**
     * Bucket approach
     */
    class Solution {

        public int hIndex(int[] citations) {

            int[] bucket = new int[citations.length + 1];

            for (int i = 0; i < citations.length; i++) {
                if (citations[i] > citations.length) {
                    bucket[citations.length]++;
                } else {
                    bucket[citations[i]]++;
                }
            }

            int sum = 0;

            for (int i = bucket.length - 1; i >= 0; i--) {

                sum += bucket[i];
                if (sum >= i) return i;

            }

            return 0;

        }
    }
}
