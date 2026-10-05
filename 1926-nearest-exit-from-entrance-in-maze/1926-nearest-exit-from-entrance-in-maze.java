class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || maze[newRow][newCol] == '+') {
                        continue;
                    }

                    if (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1) {
                        return steps;
                    }

                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return -1;
    }
}