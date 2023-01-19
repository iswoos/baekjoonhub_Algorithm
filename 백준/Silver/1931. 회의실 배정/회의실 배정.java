import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. N에따라 개수 지정
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] arr = new int[N][2];

        // 2. N개수에 따라 값 기입
        for (int i = 0; i < N; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }


        //  Comparable 혹은 Comparator의 차이! >> 이거 자주 보자. 명확하고 쉽게 설명해주었다.
        // https://st-lab.tistory.com/243

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end = -1;

        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}