class Solution {
    public boolean checkRecord(String s) {
        int aCnt = 0, lCnt = 0;
        for(int idx = 0; idx < s.length(); idx ++) {
            if(s.charAt(idx) == 'A'){
                aCnt++;
            }
            if(idx > 1 &&
               s.charAt(idx) == 'L' &&
               s.charAt(idx - 1) == 'L'&&
                s.charAt(idx - 2) == 'L'){
                lCnt++;
            }
        }
        return aCnt > 1 || lCnt > 0? false : true ;
    }
}