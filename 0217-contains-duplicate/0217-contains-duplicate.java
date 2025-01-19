import java.util.*;
class Solution {

    // brute Force On2
    // public boolean containsDuplicate(int[] nums) {
    //     for(int i=0 ; i<nums.length ; i++){
    //         for(int j=i+1 ; j<nums.length; j++){
    //             if(nums[i]==nums[j]){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // O(n)
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0)+1);
            if(hm.get(nums[i])>1){
                return true;
            }
        }
        return false;
     }
}