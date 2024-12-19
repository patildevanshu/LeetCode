class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // leftMax Height
        int[] leftHeight = new int[n];
        leftHeight[0] = height[0];
        for(int i=1; i<n ; i++){
            leftHeight[i] = Math.max(height[i] , leftHeight[i-1]);
        }

        // rightHeight
        int[] rightHeight = new int[n];
        rightHeight[n-1] = height[n-1];
        for(int i=n-2 ; i>=0 ; i--){
            rightHeight[i] = Math.max(height[i] , rightHeight[i+1]) ;
        }

        // trapped water

        int tpWater = 0;

        for(int i=0; i<n ; i++){
            // waterlevel

            int waterLevel = Math.min(leftHeight[i] ,rightHeight[i] );

            // trapped water 

            tpWater += waterLevel - height[i];
        }
        return tpWater;

    }
}