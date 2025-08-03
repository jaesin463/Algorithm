import java.util.*;

class Solution {
    static class Robot {
        int r, c;
        int destination;
        
        public Robot(int[] position) {
            this.r = position[0];
            this.c = position[1];
        }
        
        public void move(int[] point) {
            if(r != point[0]) {
                r = r < point[0] ? r + 1 : r - 1;
            } else if (c != point[1]) {
                c = c < point[1] ? c + 1 : c - 1;
            }
        }
        
        public boolean isArrived(int[] point) {
            return r == point[0] && c == point[1];
        }
        
        public void setDestination(int destination) {
            this.destination = destination;
        }
        
        public int[] curPosition() {
            return new int[]{this.r, this.c};
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        List<Robot> robots = deployRobot(points, routes);
        
        // 매 초 > 매 로봇 > 좌표
        List<List<int[]>> tracing = new ArrayList<>();
        for(int i = 0; i < routes.length; i++) {
            tracing.add(traceRoute(points, routes[i], robots.get(i)));
        }
        
        return collision(tracing);
    }
    
    public List<Robot> deployRobot(int[][] points, int[][] routes) {
        List<Robot> robots = new ArrayList<>();
        
        for (int[] route : routes) {
            int[] startPoint = points[route[0] - 1];
            robots.add(new Robot(startPoint));
        }
        
        return robots;
    }
    
    public List<int[]> traceRoute(int[][] points, int[] route, Robot robot) {
        List<int[]> routes = new ArrayList<>();
        routes.add(robot.curPosition());
        
        for(int i = 1; i < route.length; i++) {
            robot.setDestination(route[i]);
            int[] targetPoint = points[robot.destination - 1];
            while(!robot.isArrived(targetPoint)) {
                robot.move(targetPoint);
                routes.add(robot.curPosition());
            }
        }
        
        return routes;
    }
    
    public int collision(List<List<int[]>> tracing) {
        int result = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(List<int[]> trace : tracing){
            for(int i = 0; i < trace.size(); i++) {
                String key = i + " " + trace.get(i)[0] + " " + trace.get(i)[1];
                map.merge(key, 1, Integer::sum);
            }
        }
        
        for(Integer value : map.values()) {
            result = value > 1 ? result + 1 : result;
        }
        
        return result;
    }
}