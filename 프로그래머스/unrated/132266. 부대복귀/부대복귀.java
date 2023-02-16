import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int from = road[0] - 1;
            int to = road[1] - 1;
            graph.get(from).add(to);
            graph.get(to).add(from); // 양방향 그래프
        }
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination - 1] = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(destination - 1);
        
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
