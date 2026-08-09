class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length>s.length()){
            return new ArrayList<>();
        }

        Map<String, Integer> required = new HashMap<>();
        for(String str : words){
            required.put(str, required.getOrDefault(str, 0)+1);
        }

        int wordLen = words[0].length();
        int windowLen = wordLen*words.length;

        List<Integer> result = new ArrayList<>(); 

        for(int offset=0; offset<wordLen; offset++){
            int left = offset;
            int right = offset;
    
            Map<String, Integer> window = new HashMap<>();
            int count = 0;

            while((right+wordLen)<=s.length()){
                String word = s.substring(right, right+wordLen);
                right += wordLen;

                if(!required.containsKey(word)){
                    window.clear();
                    count=0;
                    left=right;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0)+1);
                count++;


                while(window.get(word)>required.get(word)){
                    
                    String trimed = s.substring(left, left+wordLen);

                    window.put(trimed, window.get(trimed)-1);
                    count--;
                    left += wordLen;
                }
                
                if(count==words.length){
                    result.add(left);
                    String trimed = s.substring(left, left+wordLen);

                    window.put(trimed, window.get(trimed)-1);
                    count--;
                    left += wordLen;   
                }

            }    
        }
        return result;
    }
}