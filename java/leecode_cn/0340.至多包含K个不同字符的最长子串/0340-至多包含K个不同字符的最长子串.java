class Solution {
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if(k * s.length() == 0) return 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> hm = new HashMap<>(k + 1);
        
        int max_len = 1;
        while(right < s.length()) {
            hm.put(s.charAt(right), right++);
            if(hm.size() == k + 1) {
                int del_idx = Collections.min(hm.values());
                hm.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
    
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if(k * s.length() == 0) return 0;
        int left = 0, right = 0;
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>(k + 1);
        
        int max_len = 1;
        while(right < s.length()) {
            Character ch = s.charAt(right);
            if(hm.containsKey(ch)) hm.replace(ch, right++);
            else hm.put(ch, right++);
            
            if(hm.size() == k + 1) {
                Map.Entry<Character, Integer> leftMost = hm.entrySet().iterator().next();
                hm.remove(leftMost.getKey());
                left = leftMost.getValue() + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)]++ == 0) num++;
            if(num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}