class Solution {
    public int solution(int[][] triangle) {
        return dp(triangle);
    }
    
    public int dp(int[][] triangle) {
        int depth = triangle.length;
        
        if(depth == 1)
            return triangle[0][0];
        
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        dp[0][0] = triangle[0][0];
        
        for(int n = 1; n < triangle.length; n++) {
            for(int m = 0; m < triangle[n].length; m++) {
                if(m == 0)
                    dp[n][m] = dp[n - 1][m] + triangle[n][m];
                else if(m == triangle[n].length - 1)
                    dp[n][m] = dp[n - 1][m - 1] + triangle[n][m];
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n - 1][m - 1]) + triangle[n][m];        
            }
        }
        
        int max = 0;
        for(int num : dp[triangle.length - 1])
            max = Math.max(max, num);
        
        return max;
    }
}