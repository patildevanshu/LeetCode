class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // System.out.println(n);
        int max=Integer.MIN_VALUE;
        int negativeInt = Integer.MIN_VALUE;
        int sum =0;

        for(int i=0 ; i<n ;i++){
            negativeInt = Math.max(negativeInt , nums[i]);
            sum =(nums[i] + sum) <= 0 ? 0 : sum + nums[i];
            if(max<sum){
                max=sum;
            }
            if(max==0){
                max=negativeInt;
            }
        }
        // System.out.println(max);
        return max;

    }
}