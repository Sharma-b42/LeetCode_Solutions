class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001]; // shift by 1000
        for (int num : arr) {
            count[num + 1000]++;
        }
        
        boolean[] seen = new boolean[1001]; // max possible occurrence is 1000
        for (int c : count) {
            if (c == 0) continue;
            if (seen[c]) return false;
            seen[c] = true;
        }
        return true;
    }
}