class TimeMap {
    
    HashMap<String ,HashMap<Integer,String>> totalMap;

    public TimeMap() {
        totalMap = new  HashMap<String ,HashMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!totalMap.containsKey(key))
        {
            totalMap.put(key,new HashMap<Integer,String>());
        }
        totalMap.get(key).put(timestamp,value);
        
    }
    
    public String get(String key, int ts) {
        if(!totalMap.containsKey(key))
        {
            return "";
        }
        
        for( int i = ts ; i > 0 ;i-- )
        {
            if(totalMap.get(key).containsKey(i))
            {
                return totalMap.get(key).get(i);
            }
        }
        return "";
    }
}