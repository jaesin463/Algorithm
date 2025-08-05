class Solution {
    
    static class Clock {
        double time;
        
        public Clock(int hour, int min, int sec) {
            time = hour * 3600 + min * 60 + sec;
        }
        
        public double[][] calcAngle() {
            double[][] angles = new double[2][3];
            
            angles[0][0] = time / 120 % 360;
            angles[0][1] = time / 10 % 360;
            angles[0][2] = time * 6 % 360;
            
            this.time++;
            
            angles[1][0] = time / 120 % 360;
            angles[1][1] = time / 10 % 360;
            angles[1][2] = time * 6 % 360;
            
            for(int i = 0; i < 3; i++) {
                angles[1][i] = angles[1][i] != 0 ? angles[1][i] : 360;
            }
            
            return angles;
        }
        
        public void oneSecond() {
            this.time++;
        }
    }
    
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        Clock start = new Clock(h1, m1, s1);
        Clock end = new Clock(h2, m2, s2);
        
        if (start.time == 0 || start.time == 12 * 3600) {
            answer++;
        }
        
        while(start.time < end.time) {
            double[][] angles = start.calcAngle();
            
            if(angles[0][2] < angles[0][0] && angles[1][0] <= angles[1][2])
                answer++;
            
            if(angles[0][2] < angles[0][1] && angles[1][1] <= angles[1][2])
                answer++;
            
            if(angles[1][0] == angles[1][1] && angles[1][1] == angles[1][2])
                answer--;
        }
        
        return answer;
    }
    
        
}

