import java.util.*;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSumTargetZero {

    public static void main(String args[]){
        int nums[] = {-1,0,1,2,-1,-4}; //o/p - [[-1,-1,2],[-1,0,1]]
        List<List<Integer>> result = getThreeSumTargetZero(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> getThreeSumTargetZero(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k] ;
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                }
                else if(sum < target){
                    j++;
                }
                else
                    k--;
            }
        }
        list.addAll(set);
        return list;
    }
}
/*
APPROACH -

Sort the input array
Initialize a set to store the unique triplets and an output vector to store the final result
Iterate through the array with a variable i, starting from index 0.
Initialize two pointers, j and k, with j starting at i+1 and k starting at the end of the array.
In the while loop, check if the sum of nums[i], nums[j], and nums[k] is equal to 0.
 If it is, insert the triplet into the set and increment j and decrement k to move the pointers.
If the sum is less than 0, increment j. If the sum is greater than 0, decrement k.
After the while loop, iterate through the set and add each triplet to the output vector.
Return the output vector
 */

//Another way -

/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    */
/**
     * Finds all unique triplets in the array that sum to zero.
     * @param nums The input integer array.
     * @return A list of unique triplets.
     *//*

    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to efficiently handle duplicates and use the two-pointer approach
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Iterate through the array with the first pointer 'i'
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for 'i' to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Break if the current number is positive (since the array is sorted,
            // no three numbers will sum to zero if the first is already positive)
            if (nums[i] > 0) {
                break;
            }

            // Initialize the two pointers for the remaining elements
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet that sums to zero
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for 'left' and 'right' pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inward to continue the search
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, increment the left pointer to increase the sum
                    left++;
                } else {
                    // Sum is too large, decrement the right pointer to decrease the sum
                    right--;
                }
            }
        }

        return result;
    }
}
*/
