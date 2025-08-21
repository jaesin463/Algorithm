import java.util.*;

class Solution {    
    public int solution(int[] sales, int[][] links) {
        Map<Integer, List<Integer>> teams = makeTeam(sales, links);
        
        int[][] dp = new int[sales.length + 1][2];
        participate(1, dp, teams, sales);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void participate(int leader, int[][] dp, Map<Integer, List<Integer>> teams, int[] sales) {
        dp[leader][1] = sales[leader - 1];
        int min = 123_456_789;
        
        if(teams.containsKey(leader)) {
            List<Integer> members = teams.get(leader);
            
            for(int member : members) {
                participate(member, dp, teams, sales);
                // 팀원 불참
                if(dp[member][0] < dp[member][1]) {
                    dp[leader][0] += dp[member][0];
                    dp[leader][1] += dp[member][0];
                    min = Math.min(dp[member][1] - dp[member][0], min);
                }
                // 팀원 참석
                else {
                    dp[leader][0] += dp[member][1];
                    dp[leader][1] += dp[member][1];
                    min = 0;
                }
            }
            
            dp[leader][0] += min;
        }
    }
    
    public Map<Integer, List<Integer>> makeTeam(int[] sales, int[][] links) {
        Map<Integer, List<Integer>> team = new HashMap<>();
        
        for(int[] link : links) {
            int from = link[0];
            int to = link[1];
            
            if(!team.containsKey(from))
                team.put(from, new ArrayList<>());
            team.get(from).add(to);
        }
        
        return team;
    }
}