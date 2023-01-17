import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] arr = new int[N];

        // 동전 총 개수에 따른 동전금액대별 입력배열 완성
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                count += K / arr[i];
                K = (K % arr[i]);
            }
        }

        System.out.println(count);
    }
}