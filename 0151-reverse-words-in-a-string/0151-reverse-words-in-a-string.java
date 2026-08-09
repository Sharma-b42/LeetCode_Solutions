class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.length()==0 || s.length()==1){
            return s;
        }

        String[] str = s.split("\\s+");
        StringBuilder result = new StringBuilder();

        for(int i=str.length-1; i>=0; i--){
            result.append(str[i]);
            if(i!=0){
                result.append(" ");
            }
        }
        return result.toString(); 
    }    
}