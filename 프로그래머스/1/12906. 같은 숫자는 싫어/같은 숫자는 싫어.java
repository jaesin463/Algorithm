import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {

        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(stack.isEmpty() || stack.peek() != num){
                stack.push(num);
            }
        }
        
        return stack;
    }
}