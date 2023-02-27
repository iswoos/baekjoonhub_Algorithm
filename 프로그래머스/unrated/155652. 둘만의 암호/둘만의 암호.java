import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        // char 'a' 의 ASCII 코드는 97 // +1을 하는 등, int계산 가능함
        // char 'z' 의 ASCII 코드는 122

        // s를 char 배열로 전환
        char[] charArr = s.toCharArray();

        // char 배열 순회
        for (int i = 0; i < charArr.length; i++) {
            for(int j = 0 ; j < index ; j++){
                // 다음 문자로 스킵 선진행
                do{
                    charArr[i]++;
                    if(charArr[i] > 'z'){ //범위 초과시 a로 돌아옴
                        charArr[i] = 'a';
                    }
                // 다음 문자가 skip에 존재하는 것이면 j++ 진행 안하고 do문 다시 진행
                }while(skip.contains(String.valueOf(charArr[i])));
            }
            answer.append(charArr[i]);
        }
        return answer.toString();
    }
}