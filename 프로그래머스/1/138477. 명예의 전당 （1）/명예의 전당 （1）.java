import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> temp = new ArrayList();

        for (int i = 0; i < score.length; i++) {
            if (temp.size() < k) {
                temp.add(score[i]);
                Collections.sort(temp);
                answer[i] = temp.get(0);
                continue;
            }
            if (temp.size() == k) {
                int miniNum = temp.get(0);

                if (miniNum < score[i]) {
                    temp.remove(0);
                    temp.add(score[i]);
                    Collections.sort(temp);
                }
                answer[i] = temp.get(0);
            }
        }
        return answer;
    }
}