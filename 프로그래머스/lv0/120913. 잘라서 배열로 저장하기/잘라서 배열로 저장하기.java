import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> answer = new ArrayList<>();

        // n에 따라서 우선 substring으로 가져온 것들을 answer에 추가
        for (int i = 0; i < (my_str.length() / n); i++) {
            answer.add(my_str.substring((n * i), (n * (i + 1))));
        }

        /*
        만약 my_str의 길이 자체가 n으로 나누어 떨어지지 않는 경우 남는 문자가 있다는 걸 의미하니,
        길이를 n으로 나눈 몫에 n을 곱하여 answer에 추가되지 않은 문자들을 substring으로 추가
        */
        if (my_str.length() % n != 0) {
            answer.add(my_str.substring( (my_str.length() / n) * n));
        }

        return answer.toArray(new String[answer.size()]);
    }
}
