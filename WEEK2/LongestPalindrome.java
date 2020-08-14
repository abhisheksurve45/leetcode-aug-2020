public class LongestPalindrome {

    class Solution {

        public int longestPalindrome(String str) {

            Set<Character> seen = new HashSet<>();
            int longestPalindrome = 0;

            for (char c : str.toCharArray()) {

                if (seen.contains(c)) {
                    longestPalindrome += 2;
                    seen.remove(c);
                } else {
                    seen.add(c);
                }

            }

            return seen.isEmpty() ? longestPalindrome : longestPalindrome + 1;

        }
    }
}
