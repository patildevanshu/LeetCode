class Solution {
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // since we are using counting sort, we want an array in which count of each element can be incremented, so k + 1 would be the lowest possible size for the array. 
        int k = max - min;
        int[] arr = new int[k + 1];

        // now increment the count of each element relative to the min value
        for (int num : nums) {
            arr[num - min]++;
        }

        int ind = 0;

        // populate the nums array by putting values from sorted array arr 
        for (int i = 0; i <= k; i++) {
            while (arr[i] > 0) {
                nums[ind] = min;
                ind++;
                arr[i]--;
            }

            min++;
        }

        return nums;
    }
}