import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        // 1. 옷을 종류별로 구분
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지않는 경우를 추가해서 모든 조합을 계산
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        // 3. 아무종류의 옷도 입지 않는 경우는 제외
        return answer -1;
    }
}