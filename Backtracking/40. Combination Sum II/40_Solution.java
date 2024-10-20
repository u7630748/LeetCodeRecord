class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;  // 紀錄目前的和

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // 排序幫助處理重複元素
        backtracking(0, target, candidates);  // 從索引 0 開始探索
        return ans;  // 返回所有符合條件的組合
    }

    private void backtracking(int ind, int target, int[] candidates) {
        if (sum == target) {  // 若當前和等於目標值，將組合加入答案
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            // 若加上當前數字會超過目標值，停止探索 (剪枝)
            if (sum + candidates[i] > target) {
                break;
            }

            // 跳過重複的數字 (避免產生重複組合)
            // i > ind：
            // 表示目前是在同一層遞迴中（例如，第 2 層遞迴內），而且 i 不是該層的第一個元素。也就是說，我們已經在這層處理過某個數字。
            // candidates[i] == candidates[i - 1]：
            // 表示當前的數字 candidates[i] 和上一個數字 candidates[i - 1] 是相同的。如果不跳過這個數字，會導致重複組合出現。
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 加入當前數字到 path，更新 sum
            sum += candidates[i];
            path.add(candidates[i]);

            // 遞迴進行下一層探索 (從 i+1 開始，避免重複使用相同元素)
            backtracking(i + 1, target, candidates);

            // 回溯：移除最後加入的數字，恢復到上一步狀態
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}