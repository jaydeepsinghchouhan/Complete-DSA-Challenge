class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int max=0;
        char[] arr=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                start=Math.max(start,map.get(arr[i])+1);
                map.put(arr[i], i);
            }           
            map.put(arr[i], i);
            max=Math.max(max, i-start+1);
        }
    return max;
    }
}