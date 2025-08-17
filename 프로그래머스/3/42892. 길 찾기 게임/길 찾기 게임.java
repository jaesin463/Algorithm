import java.util.*;

class Solution {
    static int[][] answer;
    static int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        
        Node root = makeTree(nodeinfo);
        
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        
        return answer;
    }
    
    public void preorder(Node n) {
        if(n != null) {
            answer[0][idx++] = n.num;
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    public void postorder(Node n) {
        if(n != null) {
            postorder(n.left);
            postorder(n.right);
            answer[1][idx++] = n.num;
        }
    }
    
    public Node makeTree(int[][] nodeinfo) {
        int N = nodeinfo.length;
        
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i]);
        }
        
        Arrays.sort(nodes, Comparator
                   .comparingInt((Node n) -> n.level)
                   .reversed()
                   .thenComparingInt(n -> n.value)
                   );
        
        Node root = nodes[0];
        
        for(int idx = 1; idx < N; idx++) {
            addChild(root, nodes[idx]);
        }
        
        return root;
    }
    
    public void addChild(Node parent, Node child) {
        if(parent.value > child.value) {
            if(parent.left == null) parent.left = child;
            else addChild(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else addChild(parent.right, child);
        }
    }
    
    public class Node {
        // n 번 노드
        int num;
        // value : x 값, level : y 값
        int value, level;
        // 자식 노드
        Node left, right;
        
        public Node(int num, int[] nodeinfo) {
            this.num = num;
            this.value = nodeinfo[0];
            this.level = nodeinfo[1];
        }
    }
}