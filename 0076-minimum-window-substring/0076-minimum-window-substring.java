class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if(t.length() > n){
            return "";
        }

        Map<Character , Integer> hm = new HashMap<>();

        for(char ch : t.toCharArray()){
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);
        }

        int requiredCount = t.length();
        int i=0;
        int j=0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while(j<n){
            char ch = s.charAt(j);

            if(hm.containsKey(ch) && hm.get(ch) >0){
                requiredCount--;
            }
            
            hm.put(ch , hm.getOrDefault(ch , 0) -1);

            while(requiredCount == 0){
                // starting srinking the window

                int currWindowSize = j-i+1;

                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                hm.put(startChar , hm.getOrDefault(startChar , 0) +1);

                if(hm.containsKey(startChar) && hm.get(startChar) > 0){
                    requiredCount++;
                }

                i++;
            }

            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i , start_i + minWindowSize);
    }
}