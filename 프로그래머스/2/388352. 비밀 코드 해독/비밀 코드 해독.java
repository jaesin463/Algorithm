class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        for(int bit = 0; bit < (1 << n); bit++) {
            if(Integer.bitCount(bit) == 5) {
                answer += decode(bit, q, ans);
            }
        }

        return answer;
    }

    public int decode(int bit, int[][] q, int[] ans) {
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;

            for(int num : q[i]) {
                if((bit & (1 << (num - 1))) != 0) cnt++;
            }

            if(cnt != ans[i]) return 0;
        }

        return 1;
    }
}