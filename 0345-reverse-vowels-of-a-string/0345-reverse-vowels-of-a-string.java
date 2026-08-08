class Solution {
    public String reverseVowels(String s) {
        StringBuilder str = new StringBuilder(s);
        boolean isVowel[]= new boolean[128];
        for(char c: "aeiouAEIOU".toCharArray())
            isVowel[c]=true;
        
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(!isVowel[str.charAt(left)])
                left++;
            else if(!isVowel[str.charAt(right)])
                right--;
            else{
                char temp= str.charAt(left);
                str.setCharAt(left,str.charAt(right));
                str.setCharAt(right,temp);
                left++; right--;
            }
        }
        return str.toString();

    }
}