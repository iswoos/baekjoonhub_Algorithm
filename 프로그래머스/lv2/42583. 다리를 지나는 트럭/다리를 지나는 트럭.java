import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 우선 Queue를 생성 -> queue를 다리라고 생각하자
        Queue<Integer> queue = new LinkedList<>();

        // 다리 위에 있는 트럭무게 합 저장할 변수생성
        int sum = 0;
        // 추가되는 시간을 저장할 변수생성
        int time = 0;

        // 트럭을 1개씩 추출
        for (int t : truck_weights) {
            while (true) {
                // queue가 비었을 경우 트럭 삽입
                if (queue.isEmpty()) {
                    queue.offer(t);
                    sum += t;
                    time++;
                    break;
                }
                // queue 사이즈가 다리 사이즈와 동일할 경우 트럭 1개 제거하고 다리 위 트럽합계 차감
                else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                }
                // 위 조건이 아닐경우 아래 조건문 실행
                else {
                    // 다리 위 트럭합계 + 다음 트럭 합계가 제한무게보다 클 경우 0삽입
                    if (sum + t > weight) {
                        queue.offer(0);
                        time++;
                    }
                    // 그게 아닐 경우 queue에 다음 트럭 저장 후 합계 추가
                    else {
                        queue.offer(t);
                        sum += t;
                        time++;
                        break;
                    }
                }
            }
        }
        // 총 소요된 시간 + 마지막 트럭의 통과시간(다리의 길이)
        return time + bridge_length;
    }
}