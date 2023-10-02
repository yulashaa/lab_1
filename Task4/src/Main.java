public class Main {

    public static void main(String[] args) {
        int[][] matrixA = {{2, 3, 2}, {2, 1, 3}, {1, 4, 2}};
        int[][] matrixB = {{1, 3, 2}, {1, 1, 2}, {3, 2, 4}};

        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int rowB = matrixB.length;
        int colB = matrixB[0].length;
        int[][] C = new int[rowA][colB];

        if (colA != rowB) {
            System.out.println("Multiply is impossible");
            return;
        }
        
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    C[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        System.out.println("Result after multiply :");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}