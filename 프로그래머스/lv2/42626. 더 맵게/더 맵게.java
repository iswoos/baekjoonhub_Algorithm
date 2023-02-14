import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위 큐를 활용하여 오름차순 형태로 자료구조 생성
        PriorityQueue<Integer> pq = new PriorityQueue();

        // 우선순위 큐에 scoville 데이터 기입 (오름차순으로 정렬됨)
        for (int i : scoville) {
            pq.offer(i);
        }
        // pq의 첫번째 값 (제일 작은 값)이 K 이상이 될 때까지 반복문 실행
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            // 가장 작은 값 && 그 다음 작은값 추출
            int a = pq.poll();
            int b = pq.poll();

            // 2개 값들로 만든 다른 값을 우선순위 큐에 삽입 (자동으로 정렬처리됨)
            pq.offer(a + (b * 2));
            answer++;
        }
        return answer;
    }
}