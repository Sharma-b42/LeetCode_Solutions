class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int[] pairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int low = 0;
            int high = m;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            pairs[i] = m - low;
        }

        return pairs;
    }
}