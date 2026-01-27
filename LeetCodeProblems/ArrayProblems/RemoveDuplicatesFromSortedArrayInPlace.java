import java.util.List;

public class RemoveDuplicatesFromSortedArrayInPlace {

    public static void main(String args[]){
        int nums[] = {1,1,2}; //o/p - [1,2,_]
        int result = removeDup(nums);
        System.out.println(result);

        int arr[] = {3,2,2,3};
        int val = 3;
        int removeTargetVal = removeTargetVal(arr,val);
        System.out.println(removeTargetVal);
    }

    private static int removeTargetVal(int[] nums , int val) {

        if(nums.length ==0 ) return 0;
        int res = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] !=val) {
                nums[res] = nums[i];
                res++;

            }
        }
        return res;
    }


    private static int removeDup(int[] nums) {
        if(nums.length ==0 ) return 0;
        int res = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] !=nums[i-1]) {
                nums[res] = nums[i];
                res++;

            }
        }
        return res;
    }
}

/*
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 */
//Approach
/*
1 . Initialize j = 1 (first unique element is already at nums[0]).

2 . Loop from i = 1 to end:

If nums[i] != nums[i-1] (new unique element found):
▪ Store it at nums[j]
▪ Increment j
3 . Return j (number of unique elements).
 */