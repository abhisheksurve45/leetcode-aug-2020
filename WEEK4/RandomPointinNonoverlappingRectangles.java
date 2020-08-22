public class RandomPointinNonoverlappingRectangles {

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */
    class Solution {

        private List<int[]> points;
        private static Random rand = new Random();

        public Solution(int[][] rects) {
            points = new ArrayList<>();

            for (int i = 0; i < rects.length; i++) {
                for (int x = rects[i][0]; x <= rects[i][2]; x++) {
                    for (int y = rects[i][1]; y <= rects[i][3]; y++) {
                        points.add(new int[]{x, y});
                    }
                }
            }
        }

        public int[] pick() {
            return points.get(rand.nextInt(points.size()));
        }
    }


    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */
    class Solution {

        private int[][] rects;
        private Random random;
        private TreeMap<Integer, Integer> map;
        private int sum;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            map = new TreeMap();
            sum = 0;

            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(sum, i);
            }
        }

        public int[] pick() {
            int num = map.ceilingKey(random.nextInt(sum) + 1);
            int[] xy = rects[map.get(num)];
            return new int[]{xy[0] + random.nextInt(xy[2] - xy[0] + 1), xy[1] + random.nextInt(xy[3] - xy[1] + 1)};
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */

}
