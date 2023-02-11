import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

/*      초반에 작성한 단순한 for문 코드 -> 이걸 Hash를 사용해서 효율화 시켜보자
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return answer = false;
            }
            return answer;
        }*/

        // Hashmap 생성
        Map<String, Integer> map = new HashMap<>();

        // phone_book에 있는 내용을 map에 담는다.
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // 배열의 수만큼 반복한 뒤, 배열에 해당하는 숫자의 길이만큼 반복을 돌리며 map에 포함된 값이 있는지
        // substring으로 대조
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}