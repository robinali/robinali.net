/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

 /**
    Reference: https://leetcode.com/problems/robot-room-cleaner/discuss/139057/Very-easy-to-understand-Java-solution
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, 0, 0, 0);
    }
    
    //be careful! has to be one direction v,>,^,<
    // int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    // V,<,^,> & turnLeft() also works
    private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0},{0, -1}};
    private void backtracking(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "," + y;
        if(visited.contains(path)) return;
        visited.add(path);
        robot.clean();
        
        for(int i = 0; i < 4; i++) {
            if(robot.move()) {
                int nx = x + DIRS[arrow][0];
                int ny = y + DIRS[arrow][1];
                
                backtracking(robot, visited, nx, ny, arrow);
                //track back
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }
}