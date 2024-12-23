import java.io.*;
import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        String S = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int n = S.length();
        for(int i=0; i<n/2 ; i++){
            if(S.charAt(i)!=S.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}