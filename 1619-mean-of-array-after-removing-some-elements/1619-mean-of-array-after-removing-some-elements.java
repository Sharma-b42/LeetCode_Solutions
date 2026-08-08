class Solution {
    public double trimMean(int[] arr) {
       Arrays.sort(arr);

       int removed_elements = arr.length/20;
       double sum=0;
        for(int i=removed_elements; i<(arr.length-removed_elements);i++)
            sum+=arr[i];
       int remaining_length= arr.length-(2*removed_elements);

       return  sum/remaining_length;     
    }
}