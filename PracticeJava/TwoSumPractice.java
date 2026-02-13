import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumPractice {
/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
    public static void main(String args[]){
        int arr[] = {2,7,11,15};
        int target = 9;
        int nums[] = getTwoSum(arr,target);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] getTwoSum(int[] arr, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            int complement  = target - arr[i];
            if(hm.containsKey(complement)){
                return new int[] {hm.get(complement),i};
            }
            hm.put(arr[i],i);
        }
        return new int[]{0, 0};

    }
}
