class Solution {
    public int[] productExceptSelf(int[] nums) {
        // brute force
        // {int n = nums.length;
        // int[] answer = new int[n];

        // // calculate total product
        
        // for(int i=0 ; i<n ; i++){
        //     int product=1;
        //     for(int j=0 ; j<n ; j++){
        //         if(j!=i){
        //             product *= nums[j];
        //         }
        //     }
        //     answer[i] = product;
        // }
        // return answer;}


        // time  optimized code O(n)
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        int[] postfix = new int[n];
        postfix[n-1] = 1;
        int[] ans = new int[n];

        // calculate prefix
        int prefixProduct = 1;
        for(int i=1 ; i<n ; i++){
            prefixProduct *= nums[i-1];
            prefix[i] = prefixProduct;
        }

        // calculating postfix
        int postfixProduct = 1;
        for(int i =n-2; i>=0 ; i--){
            postfixProduct *= nums[i+1];
            postfix[i] = postfixProduct;
        }

        // calculating final ans array
        for(int i=0; i<n ; i++){
            ans[i] = prefix[i]*postfix[i];
        }

        return ans;


    }
}