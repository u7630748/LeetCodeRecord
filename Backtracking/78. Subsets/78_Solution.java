
// 每一個元素都有兩種選擇：要么包含在子集中，要么不包含。最終會列出所有可能的子集。
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer>> subset = new ArrayList<>();
    dfs(0, nums, ans, subset);
    return ans;
}

private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer>> subset) {
    // Base Case
    if (i == nums.length) { // 如果已處理完所有元素
        ans.add(new ArrayList<>(subset)); // 將當前子集加入結果中
        return; // 返回上層遞迴
    }

    // 第一個遞迴選擇: 是不加入當前數字 nums[i]，直接跳到下一個數字
    dfs(i+1, nums, ans, subset);

    // 遞迴步驟2：加入 nums[i]
    subset.add(nums[i]);
    dfs(i+1, nums, ans, subset);
    subset.remove(subset.size() - 1); // 回溯，移除最後加入的數字，讓我們可以探索另一條分支
}