class Solution {
    public int fib(int n) {
        //so base condition is what if n==0 to return return 0
       if(n==0){
           return 0;
       }
        //if n==1 then return 1 as prev 0 +1=1
        // so instead of doing that we have made base case and also 
        //reason for doing so is that as we are taking last two element to do retrun current elemnt in series 
        if(n==1){
            return 1;
        }
        //this is recursive function we need to made
        int ans=fib(n-1)+fib(n-2);
        
        //finally return ans;
        return ans;
    }
}