import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {      
        Arrays.sort(bans, Comparator
                .comparingInt(String::length)     // 1차: 글자 길이
                .thenComparing(Comparator.naturalOrder()) // 2차: 사전순
        );
                
        for(String ban : bans) {
            long now = toLong(ban);
            if(n >= now) {
                n++;
            }
        }
                
        return toStr(n);
    }
    
    public Long toLong(String str) {
        long l = 0;
        for(char c : str.toCharArray()) {
            l = l * 26 + (c - 'a' + 1);
        }
        return l;
    }
    
    public String toStr(long l) {
        StringBuilder sb = new StringBuilder();
        
        while(l > 0) {
            l--;
            sb.append((char) ('a' + (l % 26)));
            l /= 26;
        }
        
        return sb.reverse().toString();
    }
    
    public int getLength(long n) {
        int length = 1;
        
        while(Math.pow(26, length) < n) {
            length++;
        }
                
        return length;
    }
}