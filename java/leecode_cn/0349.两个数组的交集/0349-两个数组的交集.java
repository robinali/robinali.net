class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1) {
            hs.add(num);
        }
        for(int num : nums2) {
            if(hs.contains(num)) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
        
        /*int [] output = new int[res.size()];
        int idx = 0;
        for (int s : res) output[idx++] = s;
        return output;*/
    }
}