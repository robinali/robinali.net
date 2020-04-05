class Solution {
    public int singleNumber(int[] nums) {
        int rtn = 0;
        for(int i : nums) {
            rtn ^= i;
        }
        return rtn;
    }
}