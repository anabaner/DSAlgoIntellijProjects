import java.util.Arrays;

public class LongestIncrSubsPractic {

    public static void main(String args[]) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18}; //o/p - {2,3,7,101} so 4
        int result = getLISubs(nums);
        System.out.println(result+" ");
    }

    private static int getLISubs(int[] nums) {

        if(nums==null || nums.length ==1 )
            return 0;

        int length = nums.length;
        int dp[] = new int[length];
        Arrays.fill(dp,1);

        for(int i = 1;i<nums.length;i++){
            for(int j=0 ;j<i;j++){
                if(nums[i]<nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
