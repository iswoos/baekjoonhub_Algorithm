import java.io.*;
import java.util.Stack;

// buffered 관련자료
// https://coding-factory.tistory.com/251

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n]; // 수열 배열생성
        int[] answer = new int[n]; // 정답 배열 생성

        String[] str = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // 스택이 비어있지않고, 스택의 인덱스값에 대비하여 다음 인덱스값이 클 경우 정답배열에 해당 값 저장
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                answer[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}