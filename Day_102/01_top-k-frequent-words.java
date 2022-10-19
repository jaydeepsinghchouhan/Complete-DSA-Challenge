class Solution {
public List topKFrequent(String[] words, int k) {
    HashMap<String,Integer> map = new HashMap<>();
    for(String word: words){
        map.put(word,map.getOrDefault(word,0)+1);
    }
    PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b)->{ 
        if(map.get(b)==map.get(a)) return a.compareTo(b);
        else return map.get(b)-map.get(a);
        });
    maxHeap.addAll(map.keySet());
    List<String> res = new ArrayList<>();
    while(k-->0){
        res.add(maxHeap.remove());
    }
    return res;
}
}