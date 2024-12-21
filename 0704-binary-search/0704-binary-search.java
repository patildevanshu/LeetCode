class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lp=0;
        int rp=n-1;
        

        while(lp<=rp){
            int mid = lp+(rp-lp)/2;

            if(nums[mid]==target){
                return mid;
            }
            if(target < nums[mid]){
                rp=mid-1;
            }else{
                lp = mid +1;
            }
            

        }
        return -1;
    }
}