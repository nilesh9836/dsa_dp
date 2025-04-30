import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        List<Integer> result = howSum(300, new int[]{7, 14}, memo);
        if (result != null) {
            for (int num : result) {
                System.out.println(num);
            }
        } else {
            System.out.println("null");
        }
    }

    public static List<Integer> howSum(int targetSum, int[] nums, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum < 0) return null;
        if (targetSum == 0) return new ArrayList<>();

        for (int num : nums) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, nums, memo);
            if (remainderResult != null) {
                List<Integer> result = new ArrayList<>(remainderResult); // Make a new list
                result.add(num); // Add current number
                memo.put(targetSum, result); // Store result for targetSum
                return result;
            }
        }

        memo.put(targetSum, null); // Cache failure result
        return null;
    }
}
