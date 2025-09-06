import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); // optional, helps pruning
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // prune (since sorted)
            curr.add(candidates[i]);
            // i (not i+1) because we can reuse same number
            backtrack(candidates, target - candidates[i], i, curr, ans);
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}
