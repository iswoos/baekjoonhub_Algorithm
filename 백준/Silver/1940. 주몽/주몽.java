import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int O = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (arr[i] + arr[j] < O) {
                i++;
            } else if (arr[i] + arr[j] > O) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
        bf.close();
    }
}