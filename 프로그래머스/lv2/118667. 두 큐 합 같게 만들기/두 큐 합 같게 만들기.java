import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long total = 0;
        long hap = 0;

        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i];
            hap += queue1[i]; //queue1의 합만 저장
            total += queue2[i]; // queue1 queue2 합 저장
            // 각 que에 각자의 값 저장
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }

        int maxCount = queue1.length * 3;
        total /= 2;

        // 두 큐 합을 같게만든다 == 한쪽만 전체합/2를 만들어도댄다.
        // 즉, 큐 1번을 기준으로두고  큐2번을 교체파츠로 보겠다

        while (hap != total) {

            if (maxCount == 0) {
                return -1;
            }
            
            if (hap > total) {
                int temp1 = que1.poll();
                hap -= temp1;
                que2.add(temp1);

            } else {
                int temp2 = que2.poll();
                hap += temp2;
                que1.add(temp2);
            }

            maxCount--;
        }

        return queue1.length * 3 - maxCount;
    }
}