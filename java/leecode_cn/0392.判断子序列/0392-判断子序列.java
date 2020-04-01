class Solution {
    public boolean isSubsequence1(String s, String t) {
        int idx = -1;
        for(char c: s.toCharArray()) {
            idx = t.indexOf(c, idx + 1);
            if(idx == -1) return false;
        }
        return true;
    }
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256];
        int i = 0;
        for(char c : t.toCharArray()) {
            if(idx[c] == null)
                idx[c] = new ArrayList<>();
            idx[c].add(i++);
        }
        
        int prev = 0;
        for(char c : s.toCharArray()) {
            if(idx[c] == null) return false;
            int j = Collections.binarySearch(idx[c], prev);
            if(j < 0) j = -j - 1;
            if(j == idx[c].size()) return false;
            prev = idx[c].get(j) + 1;
        }
        return true;
    }
}