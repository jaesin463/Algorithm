import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        Map<Integer, List<Integer>> tree = makeTree(nodes, edges);
        
        return search(tree);
    }
    
    public int[] search(Map<Integer, List<Integer>> tree) {
        // 트리와 마찬가지로 일반 boolean 배열이 아닌 Set을 활용하여 방문여부 확인
        Set<Integer> visited = new HashSet<>();
        int forward = 0;
        int reverse = 0;
        
        for(int node : tree.keySet()) {
            if(visited.contains(node))
                continue;
            
            switch (traversal(tree, visited, node)) {
                // 홀짝 가능
                case 1 :
                    forward++;
                    break;
                // 역홀짝 가능
                case 2 :
                    reverse++;
                    break;
                // 둘 다 가능
                case 3 :
                    forward++;
                    reverse++;
                    break;
            }
        }
        
        return new int[]{forward, reverse};
    }
    
    public int traversal(Map<Integer, List<Integer>> tree, Set<Integer> visited, int start) {
        int kind = 0;
        
        Queue<Integer> node = new LinkedList<>();
        visited.add(start);
        node.offer(start);
        
        int f = 0;
        int r = 0;
        while(!node.isEmpty()) {
            int cur = node.poll();
            
            List<Integer> childs = tree.get(cur);
            int nChild = childs.size();
            // 노드 번호가 짝수
            if(cur % 2 == 0) {
                // 홀짝노드
                if(nChild % 2 == 0)
                    f++;
                // 역홀짝 노드
                else
                    r++;
            } 
            else {
                if(nChild % 2 == 1)
                    f++;
                else
                    r++;
            }
            
            for(int child : childs) {
                if(visited.contains(child))
                    continue;
                
                visited.add(child);
                node.offer(child);
            }
        }
        
        if(f == 1 && r == 1) {
            kind = 3;
        } else if (f == 1) {
            kind = 1;
        } else if (r == 1) {
            kind = 2;
        }
            
        return kind;
    }
    
    public Map<Integer, List<Integer>> makeTree(int[] nodes, int[][] edges) {
        // 노드의 번호가 개수와 상관없이 별도의 제한사항을 가지므로 List가 아닌 Map 활용
        Map<Integer, List<Integer>> tree = new HashMap<>();
        
        // nodes를 순회하며 List 선언
        for(int node : nodes) {
            tree.put(node, new ArrayList<>());
        }
        
        // edges를 순회하며 양방향 간선 추가
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        return tree;
    }
}

// 우선은 그래프를 만들어야겠지

// 가능하면 트리를 구분할 수 있으면 좋겠는데

// 홀짝트리 = 노드 번호 : 자식 노드 개수 = 홀짝 : 홀짝
// 역홀짝트리 = 노드 번호 : 자식 노드 개수 = 홀짝 : 짝홀

