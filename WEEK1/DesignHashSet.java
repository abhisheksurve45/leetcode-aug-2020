public class DesignHashSet {

    /**
     * Solutiion using boolean[]
     */
    class MyHashSet {

        // Array to store presence of key in HashSet
        private boolean[] isKeyPresent;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            // key is [0, 1000000]
            this.isKeyPresent = new boolean[1000001];
        }

        public void add(int key) {
            isKeyPresent[key] = true;
        }

        public void remove(int key) {
            isKeyPresent[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return isKeyPresent[key];
        }
    }
    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
}
