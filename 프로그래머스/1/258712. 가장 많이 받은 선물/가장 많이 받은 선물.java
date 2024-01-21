import java.util.*;
import java.io.*;

class Solution {
    static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        
        //row 준 사람 / col 받은 사람
        int[][] sendGift = new int[N][N];
        int[] giftPoint = new int[N];
        int[] answers = new int[N];
        
        // 친구들 이름을 정수화
        for(int i = 0; i < N; i++){
            map.put(friends[i], i);
        }
        
        // 주어진 데이터를 변형
        for(int i = 0; i < gifts.length; i++){
            st = new StringTokenizer(gifts[i]);
            int give = map.get(st.nextToken());
            int receive = map.get(st.nextToken());
            
            // receive가 give에서 선물 받은 개수 증가
            sendGift[give][receive]++;
            // 선물 지수 조정 : 준 사람 ++ / 받은 사람 --
            giftPoint[give]++;
            giftPoint[receive]--;
        }
        
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(sendGift[i][j] == sendGift[j][i]){
                    if(giftPoint[i] > giftPoint[j]){
                        answers[i]++;
                    }
                    else if(giftPoint[i] < giftPoint[j]){
                        answers[j]++;
                    }
                } else{
                    if(sendGift[i][j] > sendGift[j][i]){
                            answers[i]++;
                    }
                        
                    else if(sendGift[i][j] < sendGift[j][i]){
                        answers[j]++;           
                        
                    }
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            answer = Math.max(answer, answers[i]);
        }
        
        return answer;
    }
}