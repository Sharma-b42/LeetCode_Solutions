class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int minutes = 0;

        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    grid[newRow][newCol] = 2;
                    freshCount--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}