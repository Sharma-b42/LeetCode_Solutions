class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0;
        int right=0;

        int count_zero=0;
        int valid_substring = 0;

        for(right=0; right<n; right++){
            if(nums[right]==0){
                count_zero += 1;
            }
            while(count_zero>k){
                if(nums[left]==0){
                    count_zero--;
                }
                left++;
            }
            valid_substring = Math.max(valid_substring, right-left+1);  
        }
        return valid_substring;
    }
}