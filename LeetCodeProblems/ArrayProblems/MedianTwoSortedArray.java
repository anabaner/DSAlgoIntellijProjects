import java.util.Arrays;

public class MedianTwoSortedArray {
/*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */


    public static void main(String args[]){
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        double medianVal = getMedian(nums1,nums2);
        System.out.println(medianVal);
    }

    private static double getMedian(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,nums,0,nums1.length);
        System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        double medianVal = 0;
        if(nums.length%2 !=0){
            medianVal = nums[nums.length/2];
        }
        else{
            medianVal = (nums[nums.length/2] + nums[nums.length/2-1])/2.0;
        }

        return medianVal;
    }
}
