class Solution {
    public String smallestNumber(String pattern) {
         int n = pattern.length();
        char[] result = new char[n + 1];//This array will hold the digits of the final answer
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            stack.push(i + 1);
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result[i - stack.size() + 1] = (char) ('0' + stack.pop());
// convert the number to a character using (char) ('0' + stack.pop()), which ensures that the number is stored as a character in the result array.As we pop from the stack, the size of the stack decreases, so we adjust the position
                }
            }
        }    
        return new String(result);
    }
}