public class NumbersWithSameConsecutiveDifferences {

    class Solution {

        private void dfs(int N, int K, int curr, int i, int prev, List<Integer> numsSameConsecDiff) {

            if (i == N - 1) {
                numsSameConsecDiff.add(curr);
                return;
            }

            int next = prev + K;

            if (next < 10) {
                dfs(N, K, (curr * 10) + next, i + 1, next, numsSameConsecDiff);
            }

            next = prev - K;

            if (K != 0 && next >= 0) {
                dfs(N, K, (curr * 10) + next, i + 1, next, numsSameConsecDiff);
            }
        }


        public int[] numsSameConsecDiff(int N, int K) {

            if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> numsSameConsecDiff = new ArrayList<>();

            for (int i = 1; i <= 9; i++) {
                dfs(N, K, i, 0, i, numsSameConsecDiff);
            }

            return numsSameConsecDiff.stream().mapToInt(i -> i).toArray();
        }
    }

}
