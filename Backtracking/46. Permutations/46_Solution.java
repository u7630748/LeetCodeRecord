List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> permutations(int[] nums) {
    if (nums.length == 0 || nums == null) {
        return ans;
    }

    backtracking(nums);
}

private void backtracking(int ind, int[] nums) {
    if (path.size() == nums.length) {
        ans.add(new ArrayList<>(path));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (path.contains(nums[i])) continue; // 如果這個數字已在當前排列中，跳過
        path.add(nums[i]);
        backtracking(nums);
        path.remove(path.size() - 1);
    }
}