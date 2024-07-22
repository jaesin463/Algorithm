import java.util.*;

public class Solution {
    public Object[] solution(int []arr) {
        Object[] answer = {};

        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() != num){
                stack.push(num);
            }
        }

        answer = stack.stream().toArray();

        return answer;
    }
}