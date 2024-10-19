class Solution {

    public String removeKDigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : nums.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            if (nums[i] != '0') {
                stack.push(i);
            }
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}