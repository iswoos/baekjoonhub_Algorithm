class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0 , 0);

        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
       // 재귀 함수시 꼭 해야할 작업
       // 1.수행동작 구현  2.탈출조건 구현  3.그림으로 그리면서 재귀동작 이해

        // 2. 탈출조건 구현
        // depth가 마지막 노드까지 되었는지, 그리고 sum값이 target값과 동일하게 되었다면 answer증가
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        // 1. 수행동작 구현
        dfs(numbers, target, depth +1, sum + numbers[depth]);
        dfs(numbers, target, depth +1, sum - numbers[depth]);
    }
}