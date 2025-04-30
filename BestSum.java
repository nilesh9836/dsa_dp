import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        List<Integer> result = bestSum(100, new int[]{1,2,25,25},memo);
        if (result != null) {
            for (int num : result) {
                System.out.println(num);
            }
        } else {
            System.out.println("null");
        }
    }

    public static List<Integer> bestSum(int targetSum, int[] nums,HashMap<Integer,List<Integer>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) {
            return new ArrayList<>();
        }
        if(targetSum<0) {
            return null;
        }
        List<Integer> bestResult = null;
        for(int i=0;i<nums.length;i++) {
            int r= targetSum - nums[i];
            List<Integer> remainderResult = bestSum(r,nums,memo);
            if(remainderResult != null) {
               List<Integer> result = new ArrayList<>(remainderResult); 
               result.add(nums[i]);
               if (bestResult == null || result.size() < bestResult.size()) {
                    bestResult = result;
                }
            }
        }
        memo.put(targetSum,bestResult);
        return bestResult;
    }
}
