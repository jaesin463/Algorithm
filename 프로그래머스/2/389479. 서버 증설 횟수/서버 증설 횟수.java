import java.util.*;

class Solution {
    // m = 서버 당 최대 이용자 수, k = 서버 운영 시간
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> server = new LinkedList<>();
        
        for(int player : players) {
            int nServer = server.size();
            int need = player / m;
            
            if(nServer < need) {
                while(nServer < need) {
                    server.offer(k - 1);
                    nServer++;
                    answer++;
                }
            }

            for(int i = 0; i < nServer; i++) {
                int t = server.poll();
                if(t > 0)
                    server.offer(t - 1);
            }
            
            
        }
        
        return answer;
    }
}