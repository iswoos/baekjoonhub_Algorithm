import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. N에따라 개수 지정
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        // 2. 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. 우선순위 큐에 데이터 넣어서 정렬
        for (int i = 0; i < N; i++) {
            pq.add(scan.nextInt());
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while (pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1+data2);
        }

        System.out.println(sum);
    }
}