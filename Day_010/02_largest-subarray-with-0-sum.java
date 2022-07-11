int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int maxim = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum+=arr[i];
            if(sum==0) {
                maxim = i+1;
            }
            else {
                if(map.get(sum) != null) {
                    maxim = Math.max(i-map.get(sum),maxim);
                }
                else {
                    map.put(sum,i);
                }
            }
            
        }
        
        return maxim;
    }
}