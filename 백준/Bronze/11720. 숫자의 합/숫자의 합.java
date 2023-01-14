import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        
        char[] cnum = s.toCharArray();

        int sum = 0;

        for (int i = 0; i < cnum.length; i++) {
            sum += cnum[i] - '0';
        }

        System.out.println(sum);
    }
}