import java.io.*;
import java.util.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        Map<String, Integer> term = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < terms.length; i++){
            term.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }

        String temp[] = today.split("\\.");
        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);
        
        for(int i = 0; i < privacies.length; i++){
            temp = privacies[i].split(" ");
            String[] date = temp[0].split("\\.");
            int type = term.get(temp[1]) * 28;
            
            int rest = (year - Integer.parseInt(date[0])) * 28 * 12
                + (month - Integer.parseInt(date[1])) * 28
                + (day - Integer.parseInt(date[2]));
            if(rest >= type)
                result.add(i + 1);
        }
        
        return result.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}