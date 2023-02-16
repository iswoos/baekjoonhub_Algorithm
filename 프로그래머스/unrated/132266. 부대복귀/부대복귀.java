import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 각 노드마다 인접한 노드들을 저장하는 리스트
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 양방향 그래프를 만들기 위해 from과 to 둘 다 저장
        for (int[] road : roads) {
            int from = road[0] - 1;
            int to = road[1] - 1;
            graph.get(from).add(to);
            graph.get(to).add(from); // 양방향 그래프
        }
        
        // 시작점에서부터의 거리 저장
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination - 1] = 0;
        
        // 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(destination - 1);
        
        // 다익스트라 알고리즘 수행
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                int dist = distance[curr] + 1;
                if (dist < distance[next]) {
                    distance[next] = dist;
                    queue.add(next);
                }
            }
        }
        
        // 결과 반환
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i] - 1;
            if (distance[source] == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = distance[source];
            }
        }
        
        return answer;
    }
}
