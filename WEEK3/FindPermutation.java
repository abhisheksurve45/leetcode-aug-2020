public class FindPermutation {

    /**
     * Question : https://www.interviewbit.com/problems/find-permutation/
     */
    public class Solution {

        public ArrayList<Integer> findPerm(final String A, int B) {

            if (A == null) return new ArrayList<>();

            int small = 1, big = B;
            ArrayList<Integer> result = new ArrayList<Integer>();

            for (int i = 0; i < A.length(); i++) {

                if (A.charAt(i) == 'I') {
                    result.add(small++);
                } else {
                    result.add(big--);
                }
            }

            if (A.charAt(A.length() - 1) == 'I') {
                result.add(big);
            } else {
                result.add(small);
            }

            return result;
        }
    }

}
