class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int windowSize = 0;
        int maxFreq = 0;

        for(int end = 0; end < s.length() ; end++){
            freq[s.charAt(end) - 'A']++;

            maxFreq = Math.max(maxFreq , freq[s.charAt(end) - 'A']);

            int windowLength = end - start +1;

            if(windowLength - maxFreq > k){
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            windowLength = end - start +1;
            windowSize = Math.max(windowSize , windowLength);
        }
        return windowSize;
    }
}