import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        // N을 뽑게되는 경우의 수는 제외하고 시작 (초기화할 때 이미 포함시켜뒀음)
        while (end_idx != N) {
            if (sum == N) {
                count++;
                end_idx++;
                sum = sum + end_idx;
            } else if (sum > N) {
                sum = sum - start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum = sum + end_idx;
            }
        }

        System.out.println(count);
    }
}