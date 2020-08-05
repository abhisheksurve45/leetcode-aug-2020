public class AddSearchWord {

    class WordDictionary {

        private static final int ALPHABETS = 26;

        /**
         * TrieNode class contains child TrieNode and end to denote end of particular word
         */
        private class TrieNode {
            private TrieNode[] child = new TrieNode[ALPHABETS];
            private boolean end;
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode trieNode = root;
            for (Character c : word.toCharArray()) {
                int index = c - 'a';
                if (trieNode.child[index] == null) {
                    trieNode.child[index] = new TrieNode();
                }
                trieNode = trieNode.child[index];
            }
            trieNode.end = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return match(word.toCharArray(), root, 0);
        }

        private boolean match(char[] word, TrieNode node, int index) {

            if (node == null) return false;

            if (index == word.length) return node.end;

            char ch = word[index];

            if (ch == '.') {

                for (int i = 0; i < ALPHABETS; i++) {
                    if (node.child[i] != null) {
                        if (match(word, node.child[i], index + 1)) {
                            return true;
                        }
                    }
                }

            } else {
                return node.child[ch - 'a'] != null && match(word, node.child[ch - 'a'], index + 1);
            }

            return false;

        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
