import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int maxLength = 0;

        while(end<s.length()){

            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength , set.size());
            }
            else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}