class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans = new int[heights.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() < heights[i]) {
                deque.pop();
                ans[i]++;
            }
            if (!deque.isEmpty()) {
                ans[i]++;
            }

            deque.push(heights[i]);
        }

        return ans;
    }
}