import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. N에따라 개수 지정
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        // 2. 우선순위 큐 생성
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        // 3. 우선순위 큐에 각 자료구조에 넣을 데이터 조건값으로 기입하여 초기화
        for (int i = 0; i < N; i++) {
            int data = scan.nextInt();

            if (data > 1) {
                plusPq.add(data);
            } else if (data == 1 ) {
                one++;
            } else if (data == 0) {
                zero++;
            } else {
                minusPq.add(data);
            }
        }

        int sum = 0;

        // 각각 저장된 자료구조를 활용하여 계산진행
        while (plusPq.size() > 1) {
            int data1 = plusPq.remove();
            int data2 = plusPq.remove();
            sum = sum + data1 * data2;
        }

        if (!plusPq.isEmpty()) {
            sum = sum + plusPq.remove();
        }

        while (minusPq.size() > 1) {
            int data1 = minusPq.remove();
            int data2 = minusPq.remove();
            sum = sum + data1 * data2;
        }

        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }

        sum = sum + one;

        System.out.println(sum);
    }
}