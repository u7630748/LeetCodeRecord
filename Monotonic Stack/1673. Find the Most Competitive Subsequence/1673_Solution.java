class Solution {
    public int[] mostCompetitve(int[] nums, int k) {
        int[] arr = new int[k]; // 儲存最具競爭力子序列的陣列
        Deque<Integer> stack = new ArrayDeque<>(); // 使用雙端佇列模擬堆疊
        int n = nums.length; // 原始陣列的長度

        for (int i = 0; i < nums.length; i++) {
            // 迴圈條件：
            // 1. 當堆疊不為空
            // 2. 還有足夠的元素讓我們構建長度為 k 的子序列 (n - i + stack.size() > k)
            // 3. 堆疊頂端的元素大於目前遍歷到的元素（我們希望更小的元素來替換）
            while (!stack.isEmpty() && n - i + stack.size() > k && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]); // 將目前的元素加入堆疊

            // 如果堆疊的大小超過 k，我們只需要前 k 個元素
            while (stack.size() > k) {
                stack.pop();
            }

            // 將堆疊中的元素取出，填入結果陣列 arr（從後往前填充）
            for (int i = k - 1; i >= 0; i--) {
                arr[i] = stack.pop();
            }
        }

        return arr; // 返回最具競爭力的子序列
    }
}