class Solution {
    public int maxArea(int arr[]){
        int maxArea =0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s = new Stack<>();

        for (int i=arr.length-1; i>= 0 ; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            }
            else{
                nsr[i]= s.peek();
            }
            s.push(i);
            
        }
        // next smaller left
        s = new Stack<>();

        for (int i=0; i<=arr.length-1 ; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] =-1;
            }
            else{
                nsl [i]= s.peek();
            }
            s.push(i);
            
        }
        // current area width = j-i-1

        for(int i =0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }



    public int maximalRectangle(char[][] matrix) {
        
        int[] height = new int[matrix[0].length];
        int largest = 0;

        for(int i=0; i<matrix.length ; i++){
            for(int j=0; j<matrix[i].length; j++){
                int val = matrix[i][j] -'0'; //converting char into int
                if(val == 0){
                    height[j] =0;
                }
                else{
                    height[j]+=1;
                }
            }
            largest = Math.max(largest , maxArea(height));
        }
        return largest;
    }
}