import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			int height[] = new int[n];
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			Stack<Integer> stack = new Stack<>();
			long max = Long.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {	
					while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
						int idx = stack.pop();
						int width = stack.isEmpty() ? i : i - stack.peek() - 1;
						max = Math.max(max, (long)width * height[idx]);
					}
					stack.push(i);
			}
			
			while (!stack.isEmpty()) {
				int idx = stack.pop();
				int width = stack.isEmpty() ? n : n - stack.peek() - 1;
				max = Math.max(max, (long)width * height[idx]);
			}
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}