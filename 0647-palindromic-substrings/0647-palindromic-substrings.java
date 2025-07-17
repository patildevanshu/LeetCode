class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1){
            return 1;
        }

        int count = s.length();

        for(int i =0 ; i< s.length() ; i++){

            // for even no. of chars present in substring
            int left = i-1;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

            // for odd no. of chars in substrigs
            left = i-1;
            right = i+1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }

        }
        return count;
    }
}