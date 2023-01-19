import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 문자열 값 입력
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();

        //
        String[] data1 = n.split("-");

        for (int i = 0; i < data1.length; i++) {
            int temp = mySum(data1[i]);

            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

        static int mySum(String a){
            int sum = 0;
            String[] temp = a.split("[+]");

            for (int i = 0; i < temp.length; i++) {
                sum = sum + Integer.parseInt(temp[i]);
            }
            return sum;
        }
    }