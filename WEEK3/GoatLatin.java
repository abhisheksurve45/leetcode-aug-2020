public class GoatLatin {

    class Solution {

        private static final Set<Character> VOWELS = new HashSet<>() {
            {
                add('a');
                add('e');
                add('i');
                add('o');
                add('u');
                add('A');
                add('E');
                add('I');
                add('O');
                add('U');
            }
        };

        public String toGoatLatin(String S) {

            String suff = "";
            StringBuilder sb = new StringBuilder();

            for (String tok : S.split(" ")) {
                suff += 'a';

                if (!VOWELS.contains(tok.charAt(0))) {
                    tok = tok.substring(1) + tok.charAt(0);
                }

                sb.append(tok).append("ma").append(suff).append(' ');
            }

            sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }
}
