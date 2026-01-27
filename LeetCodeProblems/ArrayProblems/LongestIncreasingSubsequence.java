import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int nums[] = {10,9,2,5,3,7,101,18}; //o/p - {2,3,7,101} so 4
        int result = getLIS(nums);
        int result1 = lengthOfLIS(nums);
        System.out.println(result+" "+result1);
    }

    private static int getLIS(int[] nums) {

        if(nums.length ==0 || nums==null)
            return 0;

        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for(int j = 0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }


    static int lengthOfLIS(int[] arr) {
        // Binary search approach
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the
        // first element of arr
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                // If the current number is greater
                // than the last element of the answer
                // list, it means we have found a
                // longer increasing subsequence.
                // Hence, we append the current number
                // to the answer list.
                ans.add(arr[i]);
            } else {
                // If the current number is not
                // greater than the last element of
                // the answer list, we perform
                // a binary search to find the smallest
                // element in the answer list that
                // is greater than or equal to the
                // current number.

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.
                int low = Collections.binarySearch(ans, arr[i]);

                // We update the element at the
                // found position with the current number.
                // By doing this, we are maintaining
                // a sorted order in the answer list.
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, arr[i]);
            }
        }

        // The size of the answer list
        // represents the length of the
        // longest increasing subsequence.
        return ans.size();
    }
}

/*
Approach
We can initialize an array dp of the same length as the input array nums,
where dp[i] represents the length of the longest increasing subsequence ending at index i.
 We can iterate through the array and update dp
 based on the elements before the current index. The final result will be the maximum value in the dp array.
 */