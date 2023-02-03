import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visit = new boolean[cards.length];

        ArrayList<Integer> list = new ArrayList<>();


        // cards만큼 배열을 돈다.
        // idx = cards에 담겨있는 값을 담을 변수지정 tmp = 조건에 맞을 시 각 상자 개수 카운트
        for(int i = 0 ; i < cards.length;i++){
            int idx = i;
            int count = 0;
            // 0을 택했을 때, 1을 택했을 때 ~ 마지막 수 택했을 때, 각 기준으로 while 반복문 돌림
            // 어차피 서로 얽혀있는 수들은 정해져있으니, visit을 한 뒤 다시 방문기록을 삭제할 필요는 없음
            while(!visit[idx]){
                visit[idx] = true;
                // 상자 안의 값에 따라 다시 반복문이 수행됨
                idx = cards[idx] - 1;
                count++;
            }

            // 상자 개수가 0보다 이상일 경우 리스트에 넣어둠
            if(count > 0){
                list.add(count);
            }
        }
        
        // 모든 반복문을 끝낸 뒤 오름차순 정렬
        Collections.sort(list);

        if(list.size() == 1){
            return 0;
        }
        
        // 1번째 2번째로 가장 큰 수 끼리 곱하면서 정답값 도출
        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }
}

/*
처음에 갈팡질팡을 많이 하였다...
class Solution {
    public boolean[] visit;
    public int box1 = 0;
    public int box2 = 0;

    public int solution(int[] cards) {

        visit = new boolean[cards.length];

        dfs(0, cards);

        int answer = box1 * box2;
        return answer;
    }

    private void dfs(int depth, int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            if (!visit[i] && !visit[cards[i]-1]) {
                visit[i] = true;
                box1++;
                dfs(depth + 1, cards);
                visit[i] = false;
            } else {
                visit[i] = true;
                box2++;
                dfs(depth + 1, cards);
                visit[i] = false;
            }
        }

        box1 = Math.max(box1, depth);
    }
}
*/  