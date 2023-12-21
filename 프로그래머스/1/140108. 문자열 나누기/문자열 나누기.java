class Solution {
    public int solution(String s) {
        char first = s.charAt(0);
        int same = 0;
        int dif = 0;
        int answer = 0;

        for (int i = 0; i<s.length(); i++) {
            if (same == dif) {
                answer++;
                first = s.charAt(i);
            }
            if (first == s.charAt(i)) {
                same++;
            } else{
                dif++;
            }
        }

        return answer;
    }
}