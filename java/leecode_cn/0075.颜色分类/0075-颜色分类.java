class Solution {
    public void sortColors(int[] nums) {
        // 2 pointers 0|1|2
        
        int left = 0, right = nums.length - 1;
        int idx = 0;
        while(left < right && idx <= right) {
            if(nums[idx] == 0 && idx > left)
                swap(nums, idx, left++);
            else if(nums[idx] == 2)
                swap(nums, idx, right--);
            else
                idx++;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}