//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.sumOfSeries(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // long sum = 0;
    long sumOfSeries(long N) {
    //     if(N==0) return sum;
    //     sumOfSeries(N-1);
    //     sum+=N*N*N;
    //     return sum;
    return (N*(N+1)/2)*(N*(N+1)/2);
    }
    
}