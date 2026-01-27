public class MaxWaterContained {

    public static void main(String args[]) {

        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        // formula for finding max water contained - min(arr[i],arr[j])*(j-1)
        //2 pointer approach - increase left pointer by 1 if arr[left] < arr[right] else decrease right pointer by 1.
        int result = findMaxWaterAreaContained(arr);
        System.out.print(result);
    }

    private static int findMaxWaterAreaContained(int[] arr) {
        int left = 0; int right = arr.length -1 ;
        int result = 0;
        while(left < right){

            int temp = Math.min(arr[left],arr[right])*(right-left);
            result = Math.max(temp,result);

            if(arr[left] < arr[right])
                left++;
            else
                right--;
        }
        return result;
    }

}
