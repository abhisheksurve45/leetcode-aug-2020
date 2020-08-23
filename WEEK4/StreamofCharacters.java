public class StreamofCharacters {

    class StreamChecker {

        private class TrieNode {
            private TrieNode[] next = new TrieNode[26];
            private boolean isWord;
        }

        private TrieNode root;
        private StringBuilder sb;

        public StreamChecker(String[] words) {

            this.root = new TrieNode();
            this.sb = new StringBuilder();

            for (String str : words) {
                int len = str.length();
                TrieNode node = root;

                for (int i = len - 1; i >= 0; i--) {
                    char c = str.charAt(i);
                    if (node.next[c - 'a'] == null) node.next[c - 'a'] = new TrieNode();
                    node = node.next[c - 'a'];
                }

                node.isWord = true;
            }
        }

        public boolean query(char letter) {

            sb.append(letter);
            TrieNode node = root;

            for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
                node = node.next[sb.charAt(i) - 'a'];
                if (node != null && node.isWord) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * StreamChecker obj = new StreamChecker(words);
     * boolean param_1 = obj.query(letter);
     */
}
