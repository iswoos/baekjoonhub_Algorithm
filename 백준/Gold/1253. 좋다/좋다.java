import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int answer = 0;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int k = 0; k < N; k++) {
            int find = arr[k];
            int i = 0;
            int j = N-1;

            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(answer);
        bf.close();
    }
}