public class DetectCapital {

    class Solution {
        public boolean detectCapitalUse(String word) {

            int capitalAlphabets = 0;

            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) capitalAlphabets++;
            }

            return capitalAlphabets == 0 || capitalAlphabets == word.length() || (capitalAlphabets == 1 && Character.isUpperCase(word.charAt(0)));
        }
    }
}
