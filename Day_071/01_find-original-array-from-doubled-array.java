class Solution {
    public int[] findOriginalArray(int[] changed) {
      
      if (changed.length%2 == 1)
        return new int[0];
      
      Map<Integer, Integer> map = new HashMap<>();
      
      for (int a = 0; a < changed.length; a++)
        map.put(changed[a], map.getOrDefault(changed[a], 0) + 1);
      
      int[] result = new int[changed.length/2];
      
      int count = 0;
      
      List<Integer> value = new ArrayList<>(map.keySet()); 
      
      Collections.sort(value); 
      
      for (Integer temp : value) {
        
		// when value is 0 then 2 * 0 = 0, in that case we take count/2
        if (temp == 0) {
          if (map.get(temp)%2 == 1)
            return new int[0];
          int s = map.get(temp) / 2;
          while(s-- > 0)
            result[count++] = 0;
          continue; 
        }
        
		// when smaller value is already considered 
        if (map.get(temp) == 0)
          continue; 
        
        if (map.containsKey(2 * temp)) {
          if (map.get(2 * temp) - map.get(temp) >= 0) {
            int s = map.get(temp);
            while(s-- > 0)
              result[count++] = temp; 
            map.put(2 * temp, map.get(2 * temp) - map.get(temp));
          } else {
            return new int[0]; 
          }
        } else {
          return new int[0]; 
        }
      }
      
      return result; 
      
    }
}