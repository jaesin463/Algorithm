class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int N = schedules.length;
        
        int[] scores = new int[N];
        int[] limits = setLimit(schedules, N);
        
        for(int i = 0; i < 7; i++) {
            int nowday = (startday + i) % 7;
            if(isWeekend(nowday))
               continue;
            for(int j = 0; j < N; j++) {
                if(limits[j] >= timelogs[j][i])
                    scores[j]++;
            }
        }        
        
        for(int score : scores) {
            answer = score == 5 ? answer + 1 : answer;
        }           
    
        return answer;
    }
    
    public int[] setLimit(int[] schedules, int N) {
        int[] limits = new int[N];
        
        for(int i = 0; i < N; i++) {
            int limit = schedules[i] + 10;
            limits[i] = limit % 100 >= 60 ? limit + 40 : limit;
        }
        
        return limits;
    }
    
    public boolean isWeekend(int day) {
        return day == 6 || day == 0;
    }
}