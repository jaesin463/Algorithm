class Solution {
    static int answer = 0;
    public int solution(int n) {
        calculate(0, 0, 0, n);
        return answer;
    }
    
    public void calculate(int depth, int left, int right, int n) {
        if(left == right && left == n){
            answer++;
            return;
        }
        
        if(left > n || right > n)
            return;
        
        if(left >= right && left < n) {
            calculate(depth + 1, left + 1, right, n);
        }
        
        if(left > right) {
            calculate(depth + 1, left, right + 1, n);
        }
        
    }
}