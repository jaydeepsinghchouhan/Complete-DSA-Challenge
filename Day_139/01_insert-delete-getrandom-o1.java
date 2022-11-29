class RandomizedSet {
    List<Integer> list;
    HashMap<Integer,Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<> ();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);//add in the end of the list
        map.put(val,list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //get index
        int index = map.get(val);
        //swap with the last number
        int last = list.get(list.size() - 1);
        list.set(index,last);
        map.put(last,index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;



        
    }
    
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
        
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */