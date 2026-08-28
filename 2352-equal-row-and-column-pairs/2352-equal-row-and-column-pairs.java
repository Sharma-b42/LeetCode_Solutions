class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCount = new HashMap<>();
        
       
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowCount.put(key, rowCount.getOrDefault(key, 0) + 1);
        }
        
        int result = 0;
        
        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            String key = Arrays.toString(col);
            result += rowCount.getOrDefault(key, 0);
        }
        
        return result;
    }
}