class Solution {
    public int rob(int[] nums) {
        int skip = 0;
        int take = 0;

        for (int money : nums) {
            int newTake = skip + money;
            skip = Math.max(skip, take);
            take = newTake;
        }

        return Math.max(skip, take);
    }
}