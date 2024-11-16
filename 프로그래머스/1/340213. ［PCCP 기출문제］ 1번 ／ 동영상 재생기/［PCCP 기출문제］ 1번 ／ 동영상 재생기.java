class Solution {
    static int video;
    static int op_s, op_e;
    static int now;
    
    static void next() {
        now += 10;
        
        if(now > video)
            now = video;
    }
    
    static void prev() {
        now -= 10;
        
        if(now < 0)
            now = 0;
    }
    
    static boolean isOp() {
        return op_s <= now && now <= op_e;
    }
    
    static void skip() {
        now = op_e;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        video = stringToInt(video_len);
        now = stringToInt(pos);
        op_s = stringToInt(op_start);
        op_e = stringToInt(op_end);
        
        if(isOp()) skip();
        
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next"))
                next();
            else
                prev();
            
            if(isOp()) skip();
        }
        
        return intToString(now);
    }
    
    static int stringToInt(String time) {
        String[] t = time.split(":");
        return init(t[0]) * 60 + init(t[1]);
    }
    
    static String intToString(int time) {
        String answer = "";
        
        int min = time / 60;
        int sec = time % 60;
        
        if(min < 10)
            answer = "0" + min + ":";
        else
            answer = min + ":";
        
        if(sec < 10)
            answer = answer + "0" + sec;
        else
            answer = answer + sec;
        
        return answer;
    }
    
    static int init(String str) {
        return Integer.parseInt(str);
    }
}