class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length(), m = part.length(), j = 0;
        char[] res = s.toCharArray();
        int[] lps = getLPS(part);
        Stack<Integer> state = new Stack<>();
        for (int i = 0; i < n; i++){
            res[j++] = res[i];
            int k = state.isEmpty() ? 0 : state.peek();
            while (k > 0 && part.charAt(k) != res[i])
                k = lps[k - 1];
            if (part.charAt(k) == res[i])
                k++;
            state.push(k);
            if (k == m){
                j -= m;
                for (int x = 0; x < m; x++){
                    state.pop();
                }
            }
        }
        return new String(res, 0, j);
    }

    private int[] getLPS(String s){
        int m = s.length();
        int[] lps = new int[m];
        for (int i = 1, len = 0; i < m; ){
            if (s.charAt(i) == s.charAt(len))
                lps[i++] = ++len;
            else if (len == 0)
                lps[i++] = 0;
            else
                len = lps[len - 1];
        }
        return lps;
    }
}