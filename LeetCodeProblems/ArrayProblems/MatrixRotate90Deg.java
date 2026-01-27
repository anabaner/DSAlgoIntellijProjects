public class MatrixRotate90Deg {

    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        getRotatedMatrix(matrix);
     /*   for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
*/
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getRotatedMatrix(int[][] matrix) {
        //transpose matrix

        for(int i=0 ;i<matrix.length;i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
            //reverse the values of transpose
            for(int k=0 ;k<matrix.length;k++){
                int start = 0;int end = matrix.length-1;
                while(start<end){
                   int temp =  matrix[k][start] ;
                    matrix[k][start] = matrix[k][end];
                    matrix[k][end] = temp;
                    start++;
                    end--;
                }
        }

    }
}
