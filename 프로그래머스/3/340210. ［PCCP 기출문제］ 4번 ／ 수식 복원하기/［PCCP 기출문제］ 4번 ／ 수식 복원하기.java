import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String[]> complete  = new ArrayList<>();
        List<String[]> incomplete = new ArrayList<>();
        
        for(String expression : expressions) {
            if(expression.contains("X"))
                incomplete.add(expression.split(" "));
            else
                complete.add(expression.split(" "));
        }
        
        int minBase = Math.max(getMinBase(complete), getMinBase(incomplete));
        List<Integer> bases = getBase(complete, minBase);
        
        String[] answer = calculate(incomplete, bases);
        
        return answer;
    }
    
    public String[] calculate(List<String[]> expressions, List<Integer> bases) {
        String[] result = new String[expressions.size()];
        
        for(int base : bases) {
            for(int i = 0; i < expressions.size(); i++) {
                String[] parts = expressions.get(i);
                int ans = 0;
                if(parts[1].equals("-")) {
                    ans = getNumber(parts[0], base) - getNumber(parts[2],base);
                } else {
                    ans = getNumber(parts[0], base) + getNumber(parts[2],base);
                }
                
                String answer = Integer.toString(ans, base);
                
                if(!parts[4].equals("X") && !parts[4].equals(answer) && !parts[4].equals("0"))
                    parts[4] = "?";
                else
                    parts[4] = answer;
                expressions.set(i, parts);
            }
        }
        
        for(int i = 0; i < result.length; i++) {
            String[] parts = expressions.get(i);
            result[i] = parts[0] + " " + parts[1] + " " + parts[2] + " = " + parts[4];
        }
        
        return result;
    }
        
    public List<Integer> getBase(List<String[]> expressions, int base) {
        boolean flag = false;
        List<Integer> bases = new ArrayList<>();
        while(!flag && base < 10){
            flag = true;
            for(String[] parts : expressions) {
                if(parts[1].equals("-")) {
                    if(Integer.parseInt(parts[0], base) - Integer.parseInt(parts[2], base) != Integer.parseInt(parts[4], base)){
                        flag = false;
                    }
                } else {
                    if(Integer.parseInt(parts[0], base) + Integer.parseInt(parts[2], base) != Integer.parseInt(parts[4], base)){
                        flag = false;
                    }
                }
            }
            if(flag)
                bases.add(base);
            base++;
            flag = false;
        }        
        return bases;
    }
    
    public int getNumber(String number, int base) {
        return Integer.parseInt(number, base);
    }
    
    public int getMinBase(List<String[]> expressions) {
        int maxDigit = 0;
        
        for(String[] parts : expressions) {
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[0]));
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[2]));
            maxDigit = Math.max(maxDigit, getMaxDigit(parts[4]));
        }
        
        return maxDigit + 1;
    }
    
    public int getMaxDigit(String number) {
        int maxDigit = 0;
        for(char c : number.toCharArray()) {
            if(Character.isDigit(c)) {
                maxDigit = Math.max(maxDigit, Character.getNumericValue(c));
            }
        }
        return maxDigit;
    }
}