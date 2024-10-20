// 目的是從一個整數陣列 nums 中找到所有長度至少為 2 的非遞減子序列。
// 非遞減的意思是：後面的元素不小於前面的元素。
// 此外，為了避免重複子序列，程式使用了一些條件來跳過重複情況。

List<List<Integer>> ans = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> nonDecreasingSub(int[] nums) {
    backtracking(0, nums);
}

private void backtracking(int ind, int[] nums) {
    if (path.size() >= 2) {
        ans.add(new ArrayList<>(path)); // 當子序列長度 >= 2，將其加入結果集
    }

    Set<Integer> set = new HashSet<>(); // 用於追蹤本層遞迴中的重複元素

    for (int i = ind; i < nums.length; i++) {
        // 跳過：若當前數字小於子序列的最後一個元素，或本層已經處理過該數字
        if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) continue;
        set.add(nums[i]); // 標記當前數字在本層遞迴已處理
        path.add(nums[i]); // 將當前數字加入子序列
        backtracking(i+1, nums); // 遞迴處理下一個數字
        path.remove(path.size() - 1); // 回溯：移除最後一個數字，嘗試其他可能性
    }
}

// 時間複雜度分析
// 時間複雜度：在最壞情況下，每個數字都有「選」或「不選」的選擇，時間複雜度為 O(n^2)。
// 空間複雜度：遞迴的深度最多為 n，因此空間複雜度為 O(n)。