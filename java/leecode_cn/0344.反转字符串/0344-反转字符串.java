class Solution {
    private void reverseString(char[] str, int left, int right) {
        if(left >= right) return;
        char tmp = str[left];
        str[left++] = str[right];
        str[right--] = tmp;
        reverseString(str, left, right);
    }
    
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }
}