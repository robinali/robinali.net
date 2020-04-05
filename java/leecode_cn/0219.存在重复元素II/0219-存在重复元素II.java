class Solution {
    // 219
    // Reference: cspiration
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Time: O(n) Space: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if((i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}