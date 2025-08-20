import java.util.*;

class Solution {
    public final int max = 222_222_222;
    public class Node implements Comparable<Node> {
        int num;
        int cost;
        
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] graph = makeGraph(n, fares);
        
        int[] costA = dijkstra(a, n, graph);
        int[] costB = dijkstra(b, n, graph);
        int[] costS = dijkstra(s, n, graph);

        int answer = compare(costA, costB, costS, n);
        
        return answer;
    }
    
    public int compare(int[] costA, int[] costB, int[] costS, int n) {
        int minCost = max;
        for(int i = 1; i < n + 1; i++) {
            minCost = Math.min(minCost, costA[i] + costB[i] + costS[i]);
        }
        return minCost;
    }
    
    public List<Node>[] makeGraph(int n, int[][] fares) {
        List<Node>[] graph = new ArrayList[n + 1 ];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }
        
        for(int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        return graph;
    }
    
    public int[] dijkstra(int start, int n, List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(cost, max);
        pq.offer(new Node(start, 0));
        cost[start] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(!visited[cur.num]) visited[cur.num] = true;
            
            for(Node v : graph[cur.num]) {
                if(!visited[v.num] && cost[v.num] > cur.cost + v.cost) {
                    cost[v.num] = cur.cost + v.cost;
                    pq.offer(new Node(v.num, cost[v.num]));
                }
            }
        }
        
        return cost;
    }
    
}