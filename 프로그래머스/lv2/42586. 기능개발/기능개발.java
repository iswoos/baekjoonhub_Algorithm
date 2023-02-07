import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 선입선출이 되여야함으로, Queue 만들자
        Queue<Integer> queue = new LinkedList<>();

        // 100% 달성율을 뺀 값을 기준으로, speeds를 이용하여 남은 일수를 도출시킴.
        // queue에 남은 일수를 집어넣어, 남은 일수를 기준으로 poll 시킬 예정
        for (int i = 0; i < progresses.length; i++) {
            progresses[i] = 100 - progresses[i];
            if (progresses[i] % speeds[i] == 0) {
                queue.offer(progresses[i] / speeds[i]);
            } else {
                queue.offer(progresses[i] / speeds[i] +1 );
            }
        }

        // queue가장 첫 번째 값 저장
        int process = queue.peek();
        // answer배열에 저장할 변수생성
        int count = 0;

        // queue 비울 때까지 실행
        while (!queue.isEmpty()) {
            // queue 첫 번째 추출값 max에 저장
            int max = queue.poll();
            // 만약 첫번째 peek값이 max보다 작을 경우
            if (process < max) {
                answer.add(count);
                count = 0;
                process = max;
            }
            // 아닐 경우 && 추출은 1개 했으니 count +1 증가
            count++;
        }

        // 남은 값 answer에 추가
        answer.add(count);

        // ArrayList to int array변경
        return answer.stream().mapToInt(i -> i).toArray();
    }
}