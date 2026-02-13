import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String args[]){
        int arr[] = {10, 2, -2, -20, 10}; //3
        int k = -10;
        int result = countSubarraySumK(arr,k);
        System.out.println(result);
    }

    private static int countSubarraySumK(int[] arr, int k) {
        int count =0 ;
        int prefixSum = 0 ;

        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0 ;i<arr.length;i++){
            prefixSum = prefixSum+arr[i];
            int remove = prefixSum-k;

            if(hm.containsKey(remove)){
                count+=hm.get(remove);
            }
            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);

        }

        return count;
    }
}

/*
3,1,2,4

currsum = currsum+arr[i]
first - currsum = 3
prefixSum = x-k = 3 - 6 = -3 , its there in map , if yes then increase count to map value of key - x-k
put the element in map
 details -
First, we will declare a map to store the prefix sums and their counts.
Then, we will set the value of 0 as 1 on the map.
Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
For each index i, we will do the following:
We will add the current element i.e. arr[i] to the prefix sum.
We will calculate the prefix sum i.e. x-k, for which we need the occurrence.
We will add the occurrence of the prefix sum x-k i.e. mpp[x-k] to our answer.
Then we will store the current prefix sum in the map increasing its occurrence by 1.


 */
