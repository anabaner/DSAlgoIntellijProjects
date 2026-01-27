import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String args[]){
        int nums[] = {100,4,200,1,3,2}; //o/p - 4 as (1,2,3,4) longest seq
        int count = getLongestSeq(nums);
        System.out.println(count);
    }

    private static int getLongestSeq(int[] nums) {
            // Get the length of the array
            int n = nums.length;

            // If the array is empty, no sequence exists
            if (n == 0) return 0;

            // Variable to store the longest sequence length found
            int longest = 1;

            // HashSet to store unique elements for O(1) lookup
            Set<Integer> st = new HashSet<>();

            // Add all elements to the set to remove duplicates
            for (int i = 0; i < n; i++) {
                st.add(nums[i]);
            }

        /* Loop through each element in the set to find
           the starting point of consecutive sequences */
            for (int it : st) {
                // If there is no number before 'it', it’s the start of a sequence
                if (!st.contains(it - 1)) {
                    // Start the count for this sequence
                    int cnt = 1;
                    // Store the current number
                    int x = it;

                    // Keep checking for the next consecutive number
                    while (st.contains(x + 1)) {
                        // Move to the next number in sequence
                        x = x + 1;
                        // Increment the length of current sequence
                        cnt = cnt + 1;
                    }

                    // Update the longest sequence length if needed
                    longest = Math.max(longest, cnt);
                }
            }

            // Return the length of the longest sequence
            return longest;
        }

}
