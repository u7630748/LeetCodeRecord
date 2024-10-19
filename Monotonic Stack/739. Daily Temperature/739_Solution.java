class Solution {
    public int[] dailyTemperature(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> deque = new ArrayQueue<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                ans[i] = deque.peek() - i;
            }
            deque.push(i);
        }

        return ans;
    }
}