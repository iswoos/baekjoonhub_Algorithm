import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());

    }
}