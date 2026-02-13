import java.util.*;

public class ThreeSumPractice {
    /*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */

    public static void main(String args[]){

        int nums[] = {-1,0,1,2,-1,-4};
        int target = 0 ;
        List<List<Integer>> list = getThreesumValues(nums, target);
        System.out.println(list);

    }

    private static List<List<Integer>> getThreesumValues(int[] nums , int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else
                    k--;
            }
        }
        list.addAll(set);
        return list;
    }
}
