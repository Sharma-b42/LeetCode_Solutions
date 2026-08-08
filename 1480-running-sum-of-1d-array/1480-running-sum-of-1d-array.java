class Solution {
    public int[] runningSum(int[] nums) {
        int[] arr= new int[nums.length];
        int i, sum=0;
        for(i=0; i<nums.length; i++){
            arr[i]=sum+nums[i];
            sum+=nums[i];
        }
        return arr;
    }
}