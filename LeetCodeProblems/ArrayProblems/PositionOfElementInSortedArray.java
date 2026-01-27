import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionOfElementInSortedArray {
    public static void main(String args[]) {
       int nums[] = {5, 7, 7, 8, 8, 10};
       int target = 7;
       // List<Integer> resList = new ArrayList<>();
        int resList[] = getPositionOfElement(nums,target);
        System.out.print(Arrays.toString(resList));

    }

    private static int[] getPositionOfElement(int[] nums, int target) {
            int first = findBound(nums, target, true);
            int last = findBound(nums, target, false);
            return new int[] {first, last};
        }

        private static int findBound(int[] nums, int target, boolean isFirst) {

            int left = 0,
                    right = nums.length - 1,
                    bound = -1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {

                    bound = mid;

                    if (isFirst)
                        right = mid - 1;
                    else
                        left = mid + 1;

                }
                else if (nums[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return bound;

        }
}

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */
