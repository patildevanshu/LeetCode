import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {

        // use of priority Queue makes the time complexity O(1)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        //inserting elements in Queue
        for(int i : nums){
            pq.add(i);
        }

        // removing top element from 1 to k-1
        for(int i=1 ; i<k ;i++){
            pq.remove();
        }

        // retunimg Kth biggest element 
        return pq.peek();

    }
}