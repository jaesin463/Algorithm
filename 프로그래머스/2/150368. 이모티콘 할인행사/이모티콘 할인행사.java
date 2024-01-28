class Solution {
    static int[] sale_per = {10, 20, 30, 40};
    static int[] max = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {

        
        // 이모티콘 개수가 적으니 할인율 다 때려봐도 될 듯?
        // 할인율은 10%, 20%, 30%, 40%
        int[] sale = new int[emoticons.length];
        dfs(0, sale, users, emoticons);
        return max;
    }
    
    public static void dfs(int depth, int[] sale,
                           int[][] users, int[] emoticons){
        if(depth == sale.length){
            int[] temp = calc(sale, users, emoticons);
            if(max[0] < temp[0])
                max = temp;
            else if(max[0] == temp[0] && max[1] < temp[1])
                max = temp;
            return;
        }
        
        for(int i = 0; i < 4; i++){
            sale[depth] = sale_per[i];
            dfs(depth + 1, sale, users, emoticons);
        }
    }
    
    public static int[] calc(int[] sale, int[][] users, int[] emoticons){
        int[] cost = new int[users.length];
        for(int i = 0; i < emoticons.length; i++){
            for(int j = 0; j < users.length; j++){
                if(sale[i] >= users[j][0]){
                    cost[j] += (emoticons[i] * (100 - sale[i])) / 100;
                }
            }
        }
        
        int sum = 0;
        int plus = 0;
        for(int i = 0 ; i < users.length; i++){
            if(cost[i] >= users[i][1]){
               plus++; 
            } else {
                sum += cost[i];
            }
        }
        
        int[] result = {plus, sum};
        return result;
    }
}