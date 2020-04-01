class Solution {
    /**
        Reference: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/
    */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();
        
        int left = 0, right = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int max_len = 2;
        while(right < s.length()) {
            if(hm.size() < 3) {
                hm.put(s.charAt(right), right++);
            }
            if(hm.size() == 3) {
                int del_idx = Collections.min(hm.values());
                hm.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
}