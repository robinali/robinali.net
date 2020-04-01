class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] floor = new int[cost.length + 1];
        floor[0] = 0;
        floor[1] = 0;
        for(int i = 2; i <= cost.length; i++) {
            floor[i] = Math.min(floor[i - 1] + cost[i - 1], floor[i - 2] + cost[i - 2]);
        }
        return floor[cost.length];
    }
}