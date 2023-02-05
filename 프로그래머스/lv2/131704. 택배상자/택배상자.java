import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub_container = new Stack<>(); // 보조 컨테이너 벨트

        int container_box = 1; // 현재 메인 컨테이너 벨트에 있는 박스
        for (int e : order) {
            while(container_box <= order.length) { // 현재 순서에 맞는 택배상자가 올때까지 보조 컨테이너 벨트에 저장
                if (container_box == e) { // 메인 컨테이너 벨트에 순서에 맞는 택배상자가 있다면
                    break; // 반복문 탈출
                } else if (!sub_container.isEmpty() && sub_container.peek() == e) { // 보조 컨테이너 벨트에 순서에 맞는 택배상자가 있다면
                    break; // 반복문 탈출
                } else { // 둘 다 없다면, 상자가 있을때까지 보조 컨테이너 벨트에 저장하며 탐색해야 한다.
                    sub_container.push(container_box); // 보조 컨테이너 벨트에 저장
                    container_box++; // 1 증가시켜 다음 메인 컨테이너 상자
                }
            }
            
            // 스택에 다 저장을 했음 && 탐색 시작
            if (container_box == e) { // 만약 컨테이너 벨트에서 순서에 맞는 택배상자가 있다면
                container_box++; // 메인 컨테이너 벨트에서 하나 꺼내고
                answer++; // 정답 증가
            } else if (!sub_container.isEmpty() && sub_container.peek() == e) { // 만약 보조 컨테이너 벨트에서 순서에 맞는 택배상자가 있다면
                sub_container.pop(); // 보조 컨테이너 벨트에서 하나 꺼내고
                answer++; // 정답 증가
            } else { // 둘다 없다면 실을 수 없으므로 종료
                break;
            }
        }
        return answer;
    }
}