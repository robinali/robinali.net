class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return;
        int rotate = k % nums.length;
        
        // reverse 3 times: 0 .. k - 1, k .. N - 1, 0 .. N - 1
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotate - 1);
        reverse(nums, rotate, nums.length - 1);
        return;
    }
    
    private void reverse (int[] nums, int start, int end) {
        if(start >= end) return;
        int temp;
        for(int i = start; i <= (end + start) >>> 1; i++) {
            temp = nums[i];
            nums[i] = nums[end - i + start];
            nums[end - i + start] = temp;
        }
    }
}