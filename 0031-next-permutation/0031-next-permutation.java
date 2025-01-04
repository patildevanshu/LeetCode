class Solution {
    public void nextPermutation(int[] nums) {
        int pvt = -1;
        int n = nums.length;

        for(int i=n-2; i>=0 ; i--){
            if(nums[i]<nums[i+1]){
                pvt = i;
                break;
            }
        }
        if(pvt == -1){
            int lp = pvt+1;
            int rp = n-1;
            while(lp<rp){
                int temp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = temp;
                lp++;
                rp--;
            }
        }else{
            for(int i=n-1 ; i>pvt ; i--){
                if(nums[i] > nums[pvt]){
                    int temp = nums[pvt];
                    nums[pvt] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            int lp = pvt+1;
            int rp = n-1;
            while(lp<rp){
                int temp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = temp;
                lp++;
                rp--;
            }
        }
        
    }
}