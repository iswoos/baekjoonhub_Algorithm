// class Solution {
//     public String solution(String[] cards1, String[] cards2, String[] goal) {
//         int idx1 = 0; // cards1 배열의 인덱스
//         int idx2 = 0; // cards2 배열의 인덱스
        
//         // goal 배열 순회
//         for (String currentStr : goal) {
//             // currentStr이 cards1[idx1] 또는 cards2[idx2]에 포함하는지 확인
//             if (idx1 < cards1.length && currentStr.equals(cards1[idx1])) {
//                 idx1++; // cards1[idx1]에 포함하는 경우 idx1 증가
//             } else if (idx2 < cards2.length && currentStr.equals(cards2[idx2])) {
//                 idx2++; // cards2[idx2]에 포함하는 경우 idx2 증가
//             } else {
//                 return "No"; // 둘 다 포함하지 않는 경우
//             }
//         }
        
//         return "Yes";
//     }
// }



import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for(int i=0; i<goal.length; i++){
            String target = goal[i];

            if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
                cardIdx1 ++;
            else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
                cardIdx2++;
            else
                return "No";
        }


        return "Yes";
    }
}
