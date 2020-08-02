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


    /**
     * Solution using Linked List (chaining)
     */
    class MyHashSet {

        private Bucket[] buckets;
        private int keyRange;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.keyRange = 769;
            this.buckets = new Bucket[this.keyRange];
            for (int i = 0; i < this.keyRange; ++i) {
                this.buckets[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return key % this.keyRange;
        }

        public void add(int key) {
            int bucketIndex = _hash(key);
            this.buckets[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = _hash(key);
            this.buckets[bucketIndex].delete(key);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int bucketIndex = _hash(key);
            return this.buckets[bucketIndex].exists(key);
        }
    }

    class Bucket {

        private LinkedList<Integer> container;

        public Bucket() {
            this.container = new LinkedList<Integer>();
        }

        public void insert(int key) {
            int index = this.container.indexOf(key);
            if (index == -1) this.container.addFirst(key);
        }

        public void delete(int key) {
            this.container.remove(key);
        }

        public boolean exists(int key) {
            int index = this.container.indexOf(key);
            return index != -1;
        }
    }
}
