class Solution {
    public int findMin(int[] nums) {
        int end = nums.length -1;
        int start = 0;
        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start +(end-start) /2;

            if(nums[start] <= nums[mid]){
                min = Math.min(min , nums[start]);
                start = mid + 1;  
            }else{
                min = Math.min(min , nums[mid]);
                end = mid-1;
            }
        }

        return min;
    }
}