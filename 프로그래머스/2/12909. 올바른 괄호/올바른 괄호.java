class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int on = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                on++;
            } else {
                if(on <= 0)
                    return false;
                on--;
            }
        }

        return on == 0;
    }
}