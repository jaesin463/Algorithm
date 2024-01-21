import java.util.*;

class Solution {
    static int N;
    static boolean[] visited;
    static List<int[]> diceA = new ArrayList<>();
    static List<Integer> sumA;
    static List<Integer> sumB;
    
    public int[] solution(int[][] dice) {
        int[] answer = {};
        N = dice.length;

        // 우선 A 주사위 부터 고르자
        visited = new boolean[N];
        selectA(0, 0, new int[N / 2]);
        
        int max = Integer.MIN_VALUE;
        for(int[] dA : diceA){
            int[] dB = new int[N / 2];
            boolean[] selected = new boolean[N];
            
            // B 주사위도 고름
            selectB(dA, dB, selected);
            
            // 그럼 이제 비교해야 되는데
            // 그럼 A 주사위들 경우의 수 합이랑 B 경우의 수 합이 필요하겠네
            sumA = new ArrayList<>();
            sumB = new ArrayList<>();
            combSum(0, dA, dice, 0, sumA);
            combSum(0, dB, dice, 0, sumB);
            
            // 이제 비교해야 되는데
            Collections.sort(sumA);
            Collections.sort(sumB);
            
            // sumA의 각 원소들이 sumB의 어디까지 이길 수 있는지 알면 될 듯?
            // 시간 줄이려면 이분탐색? 그냥 완탐?
            int count = 0;
            for(Integer a : sumA){
                count += binarySearch(a);
            }
            
            // 이번에 구한거랑 지금까지랑 비교
            if(count > max){
                max = count;
                answer = dA;
            }
        }

        for(int i = 0; i < N / 2; i++)
            answer[i]++;
        
        return answer;
    }
    
    public static int binarySearch(Integer a){
            int left = 0;
            int right = sumB.size();
                
            while(left + 1 < right){
                int mid = (left + right) / 2;
                    
                if(a > sumB.get(mid))
                    left = mid;
                else 
                    right = mid;
            }
                
            return left;
    }
    
    public static void combSum(int depth, int[] d, int[][] dice, int sum, List<Integer> sumList){
        // 경우의 수 끝
        if(depth == N / 2){
            // 이번 경우의 수의 합 추가
            sumList.add(sum);
            return;
        }
        
        // 구성 별로 다 돌아야 됨
        for(int i = 0; i < 6; i++){
            combSum(depth + 1, d, dice, sum + dice[d[depth]][i], sumList);
        }
    }
    
    public static void selectB(int[] dA, int[] dB, boolean[] selected){
        // dA의 값은 해당 번째 주사위를 A가 가지고 갔다 의미
        // 이미 dA에 속한 값은 true로 만들고 다음에 false인 값들을 dB에 추가할거임
        for(int select : dA){
            selected[select] = true;
        }
            
        // B가 가지게 된 주사위 반영
        int idx = 0;
        for(int i = 0; i < N; i++){
            if(!selected[i]){
                dB[idx++] = i;
            }
        }
    }
    
    // A의 주사위를 선택하는 경우의 수들을 diceA에 넣음
    // B는 이거 제외 주사위임
    public static void selectA(int depth, int now, int[] arr){
        if(depth == N / 2){
            diceA.add(arr.clone());
            return;
        }
        
        for(int i = now; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                selectA(depth + 1, i + 1, arr);
                visited[i] = false;
            }
        }
    }
}