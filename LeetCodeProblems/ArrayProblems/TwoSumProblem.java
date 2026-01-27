// https://leetcode.com/problems/two-sum/?envType=problem-list-v2&envId=array
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static void main(String args[]){

        int[] nums = {2,7,11,15};
        int target =18;
        int[] result = getIndicesofTargetSum(nums,target);
        System.out.println(Arrays.toString(result));

    }

    private static int[] getIndicesofTargetSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>(); // create a map to save the numbers and their indices (2,0),(7,1) etc

        for(int i=0;i<nums.length;i++){
            int complement = target -nums[i];
            if(hm.containsKey(complement)){
                return new int[]{hm.get(complement),i};
            }
            hm.put(nums[i],i);
        }


        return new int[]{0,0};
    }


}
