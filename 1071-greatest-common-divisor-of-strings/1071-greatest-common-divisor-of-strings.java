class Solution {
    private int gdc(int a, int b){
        while(b!=0){
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";    
        int len= gdc(str1.length(), str2.length());
        return str1.substring(0,len);
    }
}