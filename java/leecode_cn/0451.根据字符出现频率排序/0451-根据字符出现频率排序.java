class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0 ) return s;
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] != chars[i - 1]) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(chars[i]);
        }
        list.add(sb.toString());
        Collections.sort(list, (a, b) -> b.length() - a.length());
        
        sb = new StringBuilder();
        for(String str : list) sb.append(str);
        return sb.toString();
    }
}