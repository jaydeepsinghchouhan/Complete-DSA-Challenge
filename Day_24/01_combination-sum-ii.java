class Solution {
    
    private ArrayList<List<Integer>> solution;
    private ArrayList<Integer> entry;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        solution = new ArrayList<>();
        entry = new ArrayList<>();
        
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return solution;
    }
    
    private void backtrack(int[] candidates, int target, int index, int runningSum)
    {
        // If we passed our target, return so we can remove the entry and continue
        if (runningSum > target)
        {
            return;
        }
        // If we did find target, add the entry and return so we can remove the latest entry and continue
        else if (runningSum == target)
        {
            /**
            My original solution just checked if current solution set contained the detected entry.
            This produced the correct result but this would throw TLE in the lengthy test cases.
            The addition of below check at the beginning of for loop (got this from solutions):
                        if (i > index && candidates[i] == candidates[i-1]) continue;
            Prevented the need to check if solution set already contained the found entry. No more TLE.
            **/
            //if (!solution.contains(entry)) solution.add(new ArrayList<>(entry));
            solution.add(new ArrayList<>(entry));
            return;
        }
        
        //Otherwise recurse and build entry set
        for (int i = index; i < candidates.length; i++)
        {   
            if (i > index && candidates[i] == candidates[i-1]) continue;
            
            entry.add(candidates[i]);
            runningSum += candidates[i];

            //Recurse
            backtrack(candidates, target, i+1, runningSum);

            //Backtrack
            entry.remove(entry.size()-1);
            runningSum -= candidates[i];
        }
    }
}