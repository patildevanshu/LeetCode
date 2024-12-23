class Solution {
    public boolean isPalindrome(int x) {
        String y = String.valueOf(x);
        int n = y.length();
        for(int i=0; i<n/2 ; i++){
            if(y.charAt(i)!=y.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}