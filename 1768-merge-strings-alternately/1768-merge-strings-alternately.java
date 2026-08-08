class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i;
         for( i=0;i<word1.length() && i<word2.length();i++){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));

         }
         
         str.append(word1.substring(i));
         str.append(word2.substring(i));

         return str.toString();
                
    }
}