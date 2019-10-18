package com;

public class SimpleCalculations {

    //correct
    public int[][] resultMatrix(int[][] matrix1, int[][] matrix2) {
        int radix = matrix1.length;
        int[][] resultMatrix = new int[radix][radix];
        for (int i = 0; i < radix; i++) {
            for (int j = 0; j < radix; j++) {
                resultMatrix[i][j] = result(matrix1, matrix2, i, j);
            }
        }
        return resultMatrix;
    }

    //correct
    private int result(int[][] matrix1, int[][] matrix2, int row, int column) {
        int result = 0;
        for (int counter = 0; counter < matrix1.length; counter++) {
            result += matrix1[row][counter] * matrix2[counter][column];
        }
        return result;
    }

}
