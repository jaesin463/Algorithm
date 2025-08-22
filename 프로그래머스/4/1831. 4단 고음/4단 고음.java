import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int dfs(int cur, int plusCnt) {
        if (cur < 3 || 2 * (int)(Math.log(cur)/Math.log(3)) < plusCnt) return 0;
        if (cur == 3) return plusCnt == 2 ? 1 : 0;

        String key = cur + "," + plusCnt;
        if (memo.containsKey(key)) return memo.get(key);

        int count = dfs(cur - 1, plusCnt + 1);
        if (cur % 3 == 0 && plusCnt >= 2) {
            count += dfs(cur / 3, plusCnt - 2);
        }

        memo.put(key, count);
        return count;
    }

    public int solution(int n) {
        return dfs(n - 2, 2);
    }
}