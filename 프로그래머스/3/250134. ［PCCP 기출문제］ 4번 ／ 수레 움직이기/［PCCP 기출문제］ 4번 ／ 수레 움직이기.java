import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;
    
    class Cart {
        int color;
        int r, c;
        int targetR, targetC;
        boolean isArrived;
        
        public Cart(int c) {
            this.color = c;
            this.isArrived = false;
        }
        
        public int[] getPosition() {
            return new int[] {r, c};
        }
        
        public void startPoint(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        public void setTarget(int r, int c) {
            this.targetR = r;
            this.targetC = c;
        }
        
        public boolean move(int[][] maze, int[] direct, boolean[][] visited, Cart other) {
            int nR = r + direct[0];
            int nC = c + direct[1];
            
            if(index(nR, nC) && maze[nR][nC] != 5 && !visited[nR][nC] && !isArrived) {
                maze[r][c] = 0;

                r = nR;
                c = nC;
                maze[r][c] = color;
                visited[r][c] = true;
                
                if(r == targetR && c == targetC)
                    isArrived = true;
                
                return true;
            }
            
            return isArrived ? true : false;
        }
        
        public void moveback(int[][] maze, int[] origin, boolean[][] visited) {            
            if(origin[0] != targetR || origin[1] != targetC){
                isArrived = false;
                visited[r][c] = false;
                maze[r][c] = 0;
            
                this.r = origin[0];
                this.c = origin[1];

                maze[r][c] = color;
            }
        }
        
    }
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        boolean[][] redVisited = new boolean[n][m];
        boolean[][] blueVisited = new boolean[n][m];
        Cart red = new Cart(1);
        Cart blue = new Cart(2);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                switch (maze[i][j]) {
                    case 1: 
                        red.startPoint(i, j);
                        redVisited[i][j] = true;
                        break;
                    case 2: 
                        blue.startPoint(i, j);
                        blueVisited[i][j] = true;
                        break;
                    case 3:
                        red.setTarget(i, j);
                        maze[i][j] = 0;
                        break;
                    case 4:
                        blue.setTarget(i, j);
                        maze[i][j] = 0;
                        break;
                }
            }
        }
        
        moveRecur(maze, redVisited, blueVisited, red, blue, 0);
        
        return answer != Integer.MAX_VALUE ? answer : 0;
    }
    
    public void moveRecur(int[][] maze, boolean[][] rV, boolean[][] bV, Cart red, Cart blue, int time) {
        if(red.isArrived && blue.isArrived) {
            answer = Math.min(answer, time);
            return;
        }

        
        int[][] temp = {red.getPosition(), blue.getPosition()};
        for(int[] redD : delta) {
            boolean movedR = red.move(maze, redD, rV, blue);
            for(int[] blueD : delta) {
                boolean movedB = blue.move(maze, blueD, bV, red);
                
                if(!validate(temp, red, blue) && movedR && movedB) {
                    moveRecur(maze, rV, bV, red, blue, time + 1);
                    blue.moveback(maze, temp[1], bV);
                    continue;
                }
                if(movedB) blue.moveback(maze, temp[1], bV);
            }
            if(movedR) red.moveback(maze, temp[0], rV);
        }
    }
    public boolean validate(int[][] origin, Cart r, Cart b) {
        boolean isCross = (r.r == origin[1][0] && r.c == origin[1][1]) && (b.r == origin[0][0] && b.c == origin[0][1]);
        boolean isSame = r.r == b.r && r.c == b.c;
        return isCross || isSame;
    }
    
    public boolean index(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}