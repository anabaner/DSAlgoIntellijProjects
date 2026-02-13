import java.util.Arrays;

public class ArrayRotation {

    public static void main(String args[]) {
        int nums[] = {1,2,3,4,5,6,7};
        int k =3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k){
        int n=nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
/*
Approach:
Modulo Operation: Since rotating ( n ) times brings the array back to its original state, ( k ) can be reduced to ( k \mod n ).
Reverse Technique:
Reverse the entire array.
Reverse the first ( k ) elements.
Reverse the remaining ( n-k ) elements.
The final array will be the desired rotated version.
 */