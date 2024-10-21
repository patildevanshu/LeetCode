class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0 ; i< nums.length ; i++){
            int si = i;
            for(int j =i+1; j<nums.length; j++ ){
                if(nums[j]<nums[si]){
                    si = j ;
                }
            }
            // swap
            int temp = nums[i];
            nums[i] = nums[si];
            nums[si]= temp;
        }
        return nums;
    }
}