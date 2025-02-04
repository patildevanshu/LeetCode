class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;
        int left = 0;
        int right = n-1;

        while(left<right){
            int width = right - left;
            int water = Math.min(height[left] , height[right]) * width;
            maxWater = Math.max(maxWater , water);
           if(height[left]<height[right]){
                left++;
           }else{
            right--;
           }

        }
        return maxWater;
        
    }
}