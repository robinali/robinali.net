class Solution {
    public int getFib(int N, int[] cache) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        
        if(cache[N] != Integer.MIN_VALUE)
            return cache[N];
        return (getFib(N - 1, cache) + getFib(N - 2, cache));
    }
    
    public int fib(int N) {
        int[] cache = new int[N + 1];
        Arrays.fill(cache, Integer.MIN_VALUE);
        
        return getFib(N, cache);
    }
}