class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < num.length()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i++));
        }
        while(k > 0) {
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}