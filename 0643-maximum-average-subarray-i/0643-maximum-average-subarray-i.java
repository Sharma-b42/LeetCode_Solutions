class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double currentSum=0;
        double maxSum=0;

        for(int i=0;i<k;i++){
            currentSum+=nums[i];
        }
        maxSum=currentSum;
        for(int i=k;i<nums.length;i++){
            currentSum+=nums[i]-nums[i-k];
            if(currentSum>maxSum)
                maxSum=currentSum;
        }
        double mean= maxSum/k;

        return mean;
    }
}