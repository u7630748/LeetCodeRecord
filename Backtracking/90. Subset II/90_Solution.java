// See 40. Combination Sum II (is the same logic!)
List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> subsets2(int[] nums) {
    Arrays.sort(nums);
    backtracking(0, nums);
    return ans;
}

private void backtracking(int ind, int[] nums) {
    if (ind == nums.length) {
        ans.add(new ArrayList<>(path));
        return;
    }

    for (int i = ind; i < nums.length; i++) {
        if (i > ind && nums[i] == nums[i - 1]) continue;

        path.add(nums[i]);
        backtracking(i+1, nums);
        path.remove(path.size() - 1);
    }
}