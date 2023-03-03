import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // answer 배열길이 설정
        int[] answer = new int[targets.length];

        // HashMap 선언 (문자, 숫자)
        Map<Character,Integer> map = new HashMap<>();

        // keymap foreach문 진행
        for (String key : keymap) {
            // key의 길이만큼 반복문 진행
            for (int i = 0; i < key.length(); i++) {
                // key의 i번째 char값 추출
                char pointKey = key.charAt(i);
                // map에 poinkey에 해당하는 값이 없을 경우 i+1값 추출
                int step = map.getOrDefault(pointKey, i + 1);
                // map에 pointkey키의 값으로 step과 i+1을 비교하여 가장 먼저 찾을 수 있는 값으로 키 값을 업데이트
                map.put(pointKey, Math.min(step, i + 1));
            }
        }

         /*
         위 작업을 통해 keymap에 있는 모든 자료들이
         {{'A':3},{'B':1}} 등의 HashMap 자료구조로 변환되었음
         ex) 'A'는 최소 3번을 클릭해야함, 'B'는 최소 1번 클릭해야함
         */

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                // targets[i]의 char값 추출
                char targetKey = targets[i].charAt(j);
                // map에서 char값을 지니고 있을 경우 해당 값만큼 더한 값 삽입, 아닐 시에는 -1삽입
                if (map.containsKey(targetKey)) {
                    answer[i] += map.get(targetKey);
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}