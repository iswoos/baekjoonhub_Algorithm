class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        long number = num;

        while (number != 1) {
            if (count == 500) {
                return answer = -1;
            }else {
                if (number % 2 == 0) {
                    number /= 2;
                    count++;
                } else {
                    number = (number * 3) + 1;
                    count++;
                }
            }
        }

        return answer = count;
    }
}