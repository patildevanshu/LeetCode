class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        if(str == null || str.length == 0){
            return new ArrayList<>();
        }

        Map<String , List<String>> hm = new HashMap<>();

        for(String s : str){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if(!hm.containsKey(key)){
                hm.put(key , new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String , List<String>> stringAnagram : hm.entrySet()){
            result.add(stringAnagram.getValue());
        }
        return result;
    }
}