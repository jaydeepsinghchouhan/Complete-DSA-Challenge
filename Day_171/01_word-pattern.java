class Solution {
    public boolean wordPattern(String p, String s) {
        String words [] = s.split(" ");
        HashMap<Character,String> hmap = new HashMap<>();
        
        if(p.length() != words.length){
            return false;
        }
        
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            
            if(hmap.containsKey(c)){ // map word and pattern...
                String mapped = hmap.get(c);
                if(!mapped.equals(words[i])){
                    return false;
                }
            }
            else{ 
                if(hmap.containsValue(words[i])){   // check whether the word already in hashmap or not 
                    return false;
                }
                hmap.put(c,words[i]);
            }
            
        }
        
        return true;
    }
}