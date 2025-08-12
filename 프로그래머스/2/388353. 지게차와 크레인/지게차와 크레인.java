import java.util.*;

class Solution {
    static int N;
    static int M;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();  
        int nContainer = N * M;
                
        char[][] inventory = new char[N][M];
        for(int i = 0; i < N; i++) {
            inventory[i] = storage[i].toCharArray();
        }
    
        for(String request : requests) {
            char order = request.charAt(0);
            if(request.length() == 1) {
                checkChain(inventory);
                nContainer -= orderAccessible(order, inventory);
            } else {
                nContainer -= orderAll(order, inventory);
            }
        }
        
        return nContainer;
    }
    
    public void checkChain(char[][] inventory) {
        boolean[][] visited = new boolean[N][M];
        
        for(int r = 0; r < N; r++) for(int c = 0; c < M; c++) {
            // 외부와 연결되지 않았거나, 이미 방문했거나
            if(inventory[r][c] != '1' || visited[r][c])
                continue;
            
            Queue<int[]> point = new LinkedList<>();
            point.offer(new int[]{r, c});
            visited[r][c] = true;
            
            while(!point.isEmpty()) {
                int[] cur = point.poll();
                
                for(int[] d : delta) {
                    int nR = cur[0] + d[0];
                    int nC = cur[1] + d[1];
                    
                    if(!outOfIndex(nR, nC) && inventory[nR][nC] <= '1' && !visited[nR][nC]) {
                        inventory[nR][nC] = '1';
                        visited[nR][nC] = true;
                        point.offer(new int[]{nR, nC});
                    }
                }
            }
        }
    }

    public int orderAccessible(char request, char[][] inventory) {
        int count = 0;
        boolean[][] target = new boolean[N][M];
        
        for(int r = 0; r < N; r++) for(int c = 0; c < M; c++) {
            if(inventory[r][c] == request && isAccessible(inventory, r, c)) {
                target[r][c] = true;
                count++;
            }
        }
        
        for(int r = 0; r < N; r++) for(int c = 0; c < M; c++)
            inventory[r][c] = target[r][c] ? '1' : inventory[r][c];
        
        return count;
    }
    
    public boolean isAccessible(char[][] inventory, int r, int c) {
        for(int[] d : delta) {
            int nR = r + d[0];
            int nC = c + d[1];
            
            if(outOfIndex(nR, nC) || inventory[nR][nC] == '1')
                return true;
        }
        
        return false;
    }
    
    public int orderAll(char request, char[][] inventory) {
        int count = 0;
        
        for(int r = 0; r < N; r++) for(int c = 0; c < M; c++) {
            if(inventory[r][c] == request) {
                inventory[r][c] = isChain(inventory, r, c);
                count++;
            }
        }
        
        return count;
    }
    
    public char isChain(char[][] inventory, int r, int c) {
        for(int[] d : delta) {
            int nR = r + d[0];
            int nC = c + d[1];
            
            if(outOfIndex(nR, nC) || inventory[nR][nC] == '1')
                return '1';
        }
        return '0';
    }
    
    public boolean outOfIndex(int r, int c) {
        return !(r >= 0 && r < N && c >= 0 && c < M);
    }
}