class Solution {
    Set<String> res = new HashSet<>();

    private void backtrack(String s, int index,
                           int lremove, int rremove,
                           int open, StringBuilder path) {
        // if we've reached the end
        if (index == s.length()) {
            if (lremove == 0 && rremove == 0 && open == 0) {
                res.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = path.length();

        if (c == '(') {
            // option 1: remove this '(' if we still can
            if (lremove > 0) {
                backtrack(s, index + 1, lremove - 1, rremove, open, path);
            }
            // option 2: keep it
            path.append(c);
            backtrack(s, index + 1, lremove, rremove, open + 1, path);
            path.setLength(len);
        } 
        else if (c == ')') {
            // option 1: remove this ')' if we still can
            if (rremove > 0) {
                backtrack(s, index + 1, lremove, rremove - 1, open, path);
            }
            // option 2: keep it (only if there's an unmatched '(' to balance)
            if (open > 0) {
                path.append(c);
                backtrack(s, index + 1, lremove, rremove, open - 1, path);
                path.setLength(len);
            }
        } 
        else {
            // just add letters and move on
            path.append(c);
            backtrack(s, index + 1, lremove, rremove, open, path);
            path.setLength(len);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0, rremove = 0;

        // count how many '(' and ')' must be removed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lremove++;
            } else if (c == ')') {
                if (lremove > 0) {
                    lremove--;
                } else {
                    rremove++;
                }
            }
        }

        backtrack(s, 0, lremove, rremove, 0, new StringBuilder());
        return new ArrayList<>(res);
    }
}
