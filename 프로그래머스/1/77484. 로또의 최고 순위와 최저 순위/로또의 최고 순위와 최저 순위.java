import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//이 코드 진짜 깔끔하니 참고하자
//         int[] answer = new int[2];

//         int cnt1 = 0;
//         int cnt2 = 0;
//         for(int i : lottos) {
//             if(i == 0) {
//                 cnt1++;
//                 continue;
//             }
//             for(int j : win_nums) {
//                 if(i == j) cnt2++;
//             }
//         }


//         answer[0] = getGrade(cnt1+cnt2);
//         answer[1] = getGrade(cnt2);

//         return answer;
//     }


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correctMax = 0;
        int correctMin = 0;

        //HashSet생성
        ArrayList<Integer> lottoset = new ArrayList<>();
        ArrayList<Integer> winset = new ArrayList<>();
        ArrayList<Integer> zeroCount = new ArrayList<>();

        for(int lotto:lottos){
            lottoset.add(lotto);
        }

        for(int win:win_nums){
            winset.add(win);
        }

        for(int lotto:lottos){
            zeroCount.add(lotto);
        }

        for(int i=0; i<winset.size(); i++){
            if(lottoset.contains(winset.get(i))){
                correctMin++;
            }
        }

        correctMax = Collections.frequency(zeroCount,0);
        correctMax += correctMin;

        System.out.println(correctMin);
        System.out.println(correctMax);

        int[] answer = {Math.min(7-correctMax,6),Math.min(7-correctMin,6)};

        return answer;
    }
}