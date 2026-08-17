class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        
        int left = 0;
        int right = 0;
        int zero_count = 0;
        int max_size = 0;
        for(right=0; right<n; right++){
            
            if(nums[right]==0){
                zero_count += 1;
            }
            while(zero_count>1){
                if(nums[left]==0){
                    zero_count -= 1;
                }
                left++;
            }    
            max_size = Math.max(max_size, right-left);
        }
        return max_size;
    }
}