public class MaximumSubarraySumPractice {

    /*
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }

    private static int maxSubarraySum(int[] arr) {

        int res = arr[0];
        int maxEnding = arr[0];

        for(int i=1;i<arr.length;i++){

          maxEnding = Math.max(maxEnding+arr[i],arr[i]);
          res = Math.max(maxEnding,res);


        }
        return res;

    }
}
