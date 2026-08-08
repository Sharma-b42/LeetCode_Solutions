class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int gaps=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){    
                boolean emptyleft=(i==0 || flowerbed[i-1]==0);
                boolean emptyright=(i==flowerbed.length-1 || flowerbed[i+1]==0);
                if(emptyleft && emptyright){
                    gaps++;
                    flowerbed[i]=1;
                }
            }    
        }
        if(n<=gaps)
            return true;
        else
            return false;    
    }
}