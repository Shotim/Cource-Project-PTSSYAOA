package com;

public class Run {

    public static void main(String[] args) {
        int radix = 4;
        SimpleCalculations simple = new SimpleCalculations();
        ShtrassenCalculations shtrassen = new ShtrassenCalculations();
        int[][] matrix41 = {{4, 5, 7, 1}, {1, 8, 3, 1}, {6, 5, 4, 1}, {1, 1, 1, 1}};
        int[][] matrix42 = {{1, 2, 3, 1}, {4, 5, 6, 1}, {7, 8, 9, 1}, {1, 1, 1, 1}};

        int[][] matrix21 = {{3, 4}, {7, 8}};
        int[][] matrix22 = {{1, 2}, {7, 3}};

        int[][] resMatrix41 = simple.resultMatrix(matrix41, matrix42);
        viewMatrix(resMatrix41);

        int[][] resmatrix42 = shtrassen.multiplierOf4x4Matrix(matrix41, matrix42);
        viewMatrix(resmatrix42);

        int[][] resMatrix21 = simple.resultMatrix(matrix21, matrix22);
        viewMatrix(resMatrix21);

        int[][] resMatrix22 = shtrassen.multiplierOf2x2Matrix(matrix21, matrix22);
        viewMatrix(resMatrix22);
    }

    private static void viewMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");
    }
}
