public class Search2DMatrix {

    public static void main(String args[]) {
        int matrix[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 34, 50, 60}};
        int target = 11;
        boolean result = searchMatrixUsingBinarySearch(matrix, target);
        System.out.println(result);
    }

    //first approach
    private static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }

        return false;
    }

    //second approach

    // function to binary search for x in arr[]
    static boolean search(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (x == arr[mid])
                return true;
            if (x < arr[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    // function to search element x in fully
    // sorted matrix
    public static boolean searchMatrixUsingBinarySearch(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        int lo = 0, hi = n - 1;
        int row = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // if the first element of mid row is equal to x,
            // return true
            if (x == mat[mid][0])
                return true;

            // if x is greater than first element of mid row,
            // store the mid row and search in lower half
            if (x > mat[mid][0]) {
                row = mid;
                lo = mid + 1;
            }

            // if x is smaller than first element of mid row,
            // search in upper half
            else
                hi = mid - 1;
        }

        // if x is smaller than all elements of mat[][]
        if (row == -1)
            return false;

        return search(mat[row], x);
    }
}
