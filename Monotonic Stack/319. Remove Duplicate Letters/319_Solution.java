import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public String removeDuplicateLetters(String s) {
        int[] chCount = new int[256];
        for (char c : s.toCharArray()) {
            chCount[c]++;
        }

        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            chCount[c]--;

            if (set.contains(c)) continue;

            while (!deque.isEmpty() && c < deque.peek() && chCount[deque.peek()] > 0) {
                char ch = deque.pop();
                set.remove(ch);
            }

            deque.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        return sb.toString();
    }
}