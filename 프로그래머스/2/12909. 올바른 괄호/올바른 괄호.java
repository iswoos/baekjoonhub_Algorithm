import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                queue.offer(c);
            } else {
                if (queue.isEmpty()) {
                    return answer;
                } else {
                    queue.poll();
                }
            }
        }

        if (queue.isEmpty()) {
            answer = true;
        }

        return answer;
    }
}