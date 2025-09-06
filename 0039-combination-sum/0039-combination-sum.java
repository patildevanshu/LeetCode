import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int i, List<Integer> curr, List<List<Integer>> ans) {
        // base cases
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }

        // ✅ Choice 1: include candidates[i]
        curr.add(candidates[i]);
        backtrack(candidates, target - candidates[i], i, curr, ans); // don't move i (reuse allowed)
        curr.remove(curr.size() - 1);

        // ✅ Choice 2: exclude candidates[i] and move to next
        backtrack(candidates, target, i + 1, curr, ans);
    }
}
