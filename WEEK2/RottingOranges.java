public class RottingOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {

            if (grid.length == 0 || grid[0].length == 0) return 0;

            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            int fresh_cell = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) q.offer(new int[]{i, j});
                    else if (grid[i][j] == 1) {
                        fresh_cell++;
                    }
                }
            }

            if (fresh_cell == 0) return 0;

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int minutes = 0;

            while (!q.isEmpty()) {
                minutes++;

                int size = q.size();

                for (int i = 0; i < size; i++) {

                    int[] curr = q.poll();

                    for (int[] dir : dirs) {
                        int x = curr[0] + dir[0];
                        int y = curr[1] + dir[1];

                        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 || grid[x][y] == 2) continue;

                        q.offer(new int[]{x, y});
                        grid[x][y] = 2;

                        fresh_cell--;
                    }

                }

            }
            return fresh_cell == 0 ? minutes - 1 : -1;
        }
    }
}
