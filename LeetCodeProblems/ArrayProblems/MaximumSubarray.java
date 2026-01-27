public class MaximumSubarray {

    /*
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */


    public static void main(String args[]){
        int nums[] = {5,4,-1,7,8};
        int maxSum = getMaxSum(nums);
        System.out.println(maxSum);
    }

    private static int getMaxSum(int[] nums) {

        int maxSum=nums[0];
        int curr_sum=nums[0] ;

        for(int i=1;i<nums.length;i++){
            curr_sum = Math.max(curr_sum+nums[i],nums[i]);
            maxSum = Math.max(curr_sum,maxSum);
        }
        return maxSum;
    }


}
