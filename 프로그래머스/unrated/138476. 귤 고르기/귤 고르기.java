import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int answer = 0;

    public int solution(int k, int[] tangerine) {

        // 귤 사이즈별로 map에 담아준다.
        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        // 개수 기준으로 정렬시킨다.
        List<Integer> keyArr = new ArrayList<>(map.keySet());
        Collections.sort(keyArr, new customComparator());

//        for (Integer integer : keyArr) {
//            System.out.println(integer);
//        }

        for (Integer e : keyArr) {
            if (k <= 0) {
                break;
            } else {
                answer++;
                k -= map.get(e);
            }
        }

        return answer;
    }

    // 개수 기준으로 정렬시키는 용도인 객체
    public class customComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}