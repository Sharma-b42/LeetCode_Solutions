class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hashmap = new HashMap<>();

        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);

            String key = new String(c);

            if(!hashmap.containsKey(key)){
                hashmap.put(key, new ArrayList<>());
            }
            hashmap.get(key).add(str);
        }
        return new ArrayList<>(hashmap.values());
    }
}