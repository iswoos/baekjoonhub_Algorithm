// 1월 25일경 업데이트 미반영현상 발생함.. 이유 파악해야함.
// 이유 파악내용 : 어제 풀기만하고 제출을 안 했었다! 나의 불찰이였다. 소중한 잔디를 놓쳤지만, 다음에는 이런 일이 반복되지 않도록 기록화하는 것에 더욱 신경써야겠다고 느낀 경험이다.


class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long i = 0; i <= d/k; i++) {
            long x = i * k;
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2)) / k;
            
            answer += y + 1; // 0도 포함해주어야 하므로 +1
        }
        return answer;
    }
}
