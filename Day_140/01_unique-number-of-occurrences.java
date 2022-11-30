class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int a: arr){
            hash.put(a, hash.getOrDefault(a, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int a: hash.values()){
            set.add(a);
        }
        if(set.size()==hash.size()) return true;
        return false;
    }
}