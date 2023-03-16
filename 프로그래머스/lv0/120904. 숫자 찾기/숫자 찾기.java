class Solution {
    public int solution(int num, int k) {

        String strnum = num + "";
        String strk = k + "";

        int answer = strnum.indexOf(strk);

        return answer > -1 ? ++answer : answer;
    }
}