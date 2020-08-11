public class HIndex {
    class Solution {
        public int hIndex(int[] citations) {

            if (citations.length == 0) return 0;

            int hindex = 0;
            int n = citations.length;

            Arrays.sort(citations);

            for (int i = 0; i < n - 1; i++) {

                hindex = Math.max(hindex, Math.min(citations[i], n - i));

            }

            return hindex;
        }
    }
}
