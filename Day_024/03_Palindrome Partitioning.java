class Solution {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        solve(s,new ArrayList<String>(),0);
        return result;
    }
    
    private void solve(String X,List<String> temp,int start){
        if(start==X.length())
        {
            result.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int k=start;k<X.length();k++){
            if(isPalindrome(X,start,k)){
                temp.add(X.substring(start,k+1));
                
                solve(X,temp,k+1);
                temp.remove(temp.size()-1);
            } 
        }
       
    }
    private boolean isPalindrome(String X,int start,int end){
        while(start<end){
            if(X.charAt(start)!=X.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}