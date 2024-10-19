class Solution {
    public int[] maximumWidth(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty() || nums[i] < nums[deque.peek()]) {
            deque.push(i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peek()]) {
                int index = deque.pop();
                max = Math.max(max, i - index);
            }

            return max;
        }
    }
}