public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates); // 將候選數組排序，方便剪枝優化
    List<List<Integer>> ans = new ArrayList<>(); // 用來儲存所有符合條件的組合
    List<Integer> com = new ArrayList<>(); // 暫存當前的組合

    dfs(0, target, candidates, ans, com); // 開始深度優先搜尋
    return ans;
}

private void dfs(int i, int target, int[] candidates, List<List<Integer>> ans, List<Integer> com) {
    if (target == 0) { // 若 target 剛好等於 0，表示找到一組組合
        ans.add(new ArrayList<>(com)); // 將當前組合加入結果中
        return; // 返回上層遞迴
    }

    if (i >= candidates.length || target < candidates[i]) {
        return; // 若超出邊界或當前數字大於剩餘目標，則返回
    }

    // 嘗試跳過當前數字 candidates[i]，繼續處理下一個數字。
    dfs(i + 1, target, candidates, ans, com);

    com.add(candidates[i]); // 將當前數字加入組合
    dfs(i, target - candidates[i], ans, com); // 繼續嘗試減去該數字後的剩餘目標
    com.remove(com.size() - 1); // 回溯，移除最後加入的數字
}