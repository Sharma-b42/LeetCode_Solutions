class Solution {
    private int[] original;
    private int[] current;
    private Random rand;

    public Solution(int[] nums) {
        this.original=nums.clone();
        this.current=nums.clone();
        this.rand= new Random();
        
    }
    
    public int[] reset() {
        this.current=this.original.clone();
        return this.current;

    }
    
    public int[] shuffle() {
        for(int i=0;i<current.length;i++){
            int j= i+rand.nextInt(current.length-i);

            int temp= current[i];
            current[i]=current[j];
            current[j]=temp;    
        }
        return this.current;        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */