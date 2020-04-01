class Solution {
    private boolean searchMatrix(int[][] matrix, int target, int[] bounds) {
        // bounds: left up right down
        if(bounds[0] > bounds[2] || bounds[1] > bounds[3]) {
            return false;
        } else if(target < matrix[bounds[1]][bounds[0]] ||
                  target > matrix[bounds[3]][bounds[2]]) {
            return false;
        }
        
        int mid = (bounds[0] + bounds[2]) >>> 1;
        int row = bounds[1];
        while(row <= bounds[3] && matrix[row][mid] <= target) {
            if(matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchMatrix(matrix, target, new int[]{bounds[0], row, mid - 1, bounds[3]}) ||
            searchMatrix(matrix, target, new int[]{mid + 1, bounds[1], bounds[2], row - 1});
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        return searchMatrix(matrix, target, new int[]{0, 0, matrix[0].length - 1, matrix.length - 1});
    }
}