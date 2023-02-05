import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] str = new String[numbers.length];

        // String 형태로 바꿔 배열에 담는다.
        for (int i = 0; i < numbers.length; i++) {
            // 밑에 2개 모두 정상작동한다. 시간 복잡도가 낮은 걸 하단에 살려뒀다.
//            str[i] = String.valueOf(numbers[i]);
            str[i] = numbers[i]+"";
        }

        // Comparator -> compare를 이용하여 정렬을 한다.
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 밑에 2개 모두 정상작동한다. 시간 복잡도가 낮은 걸 하단에 살려뒀다.
                // {6,10,2} 순일 때, o1은 10, o2는 6이 배정된다.
//                return Integer.parseInt((o2 + o1)) - Integer.parseInt((o1 + o2));
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String s : str) {
            answer.append(s);
        }

        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}