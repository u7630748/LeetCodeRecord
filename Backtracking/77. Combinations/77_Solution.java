
List<List<Integer>> ans = new ArrayList<>();
<List<Integer> path = new ArrayList<>();

public List<List<Integer>> combinations(int n, int k) {
    backtracking(1, n, k); // 從數字1開始回溯!!
}

private void backtracking(int ind, int n, int k) {
    if (path.size() == k) {
        ans.add(new ArrayList<>(path)); // 若路徑長度為 k，將其加入結果集
        return;
    }

    // 優化剪枝：避免無效的計算。例如，如果已選了 2 個數字，只剩下一個空位，但剩餘數字不足以湊滿組合，則不再進行遞迴。
    for (int i = ind; i <= n - (k - path.size()) + 1; i++) {
        path.add(i);
        backtracking(i+1, n, k);
        path.remove(path.size() - 1);
    }
}