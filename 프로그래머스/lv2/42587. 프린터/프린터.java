import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        // 1. Queue 만들기
        List<Integer> printer = new ArrayList<>();
        for (int priority : priorities) {
            printer.add(priority);
        }
        int turn = 0;

        while (!printer.isEmpty()) {
            Integer priority = printer.remove(0);
            if (printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                printer.add(priority);
            } else {
                turn++;
                if (location == 0) {
                    break;
                }
            }

            location--;
            if (location < 0) {
                location = printer.size() - 1;
            }
        }
        return turn;
    }
}