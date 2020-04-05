class Solution {
    /**
        Reference: https://leetcode-cn.com/problems/number-of-boomerangs/solution/20200325447easy-by-jasion_han-r/
    */
    private int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

    public int numberOfBoomerangs(int[][] points) {
        int rtn = 0;

        for(int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++) {
                if(j != i) {
                    int dis = getDistance(points[i], points[j]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for(int dis : map.keySet()) {
                rtn += (map.get(dis)) * (map.get(dis) - 1);
            }
        }
        return rtn;
    }
}