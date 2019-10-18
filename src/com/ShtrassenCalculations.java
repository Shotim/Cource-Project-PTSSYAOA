package com;

public class ShtrassenCalculations {

    //correct
    public int[][] multiplierOf2x2Matrix(int[][] a, int[][] b) {
        int[][] resultMatrix = new int[2][2];

        int d1 = (a[0][0] + a[1][1]) * (b[0][0] + b[1][1]);
        int d2 = (a[1][0] + a[1][1]) * b[0][0];
        int d3 = a[0][0] * (b[0][1] - b[1][1]);
        int d4 = a[1][1] * (-b[0][0] + b[1][0]);
        int d5 = (a[0][0] + a[0][1]) * b[1][1];
        int d6 = (-a[0][0] + a[1][0]) * (b[0][0] + b[0][1]);
        int d7 = (a[0][1] - a[1][1]) * (b[1][0] + b[1][1]);

        resultMatrix[0][0] = d1 + d4 - d5 + d7;
        resultMatrix[1][0] = d2 + d4;
        resultMatrix[0][1] = d3 + d5;
        resultMatrix[1][1] = d1 + d3 - d2 + d6;
        return resultMatrix;
    }

    public int[][] multiplierOf4x4Matrix(int[][] a, int[][] b) {

        int[][][] partMatrixA = partitionOf4x4Matrix(a);
        int[][][] partMatrixB = partitionOf4x4Matrix(b);
        int[][] a00 = partMatrixA[0];
        int[][] a01 = partMatrixA[1];
        int[][] a10 = partMatrixA[2];
        int[][] a11 = partMatrixA[3];
        int[][] b00 = partMatrixB[0];
        int[][] b01 = partMatrixB[1];
        int[][] b10 = partMatrixB[2];
        int[][] b11 = partMatrixB[3];

        int[][] d1 = multiplierOf2x2Matrix(sum(a00, a11), sum(b00, b11));
        int[][] d2 = multiplierOf2x2Matrix(sum(a10, a11), b00);
        int[][] d3 = multiplierOf2x2Matrix(a00, sum(b01, inv(b11)));
        int[][] d4 = multiplierOf2x2Matrix(a11, sum(inv(b00), b10));
        int[][] d5 = multiplierOf2x2Matrix(sum(a00, a01), b11);
        int[][] d6 = multiplierOf2x2Matrix(sum(inv(a00), a10), sum(b00, b01));
        int[][] d7 = multiplierOf2x2Matrix(sum(a01, inv(a11)), sum(b10, b11));
        int[][] res00 = sum(sum(d1, d4), sum(inv(d5), d7));
        int[][] res10 = sum(d2, d4);
        int[][] res01 = sum(d3, d5);
        int[][] res11 = sum(sum(d1, d3), sum(inv(d2), d6));

        return new int[][]{
                {res00[0][0], res00[0][1], res01[0][0], res01[0][1]},
                {res00[1][0], res00[1][1], res01[1][0], res01[1][1]},
                {res10[0][0], res10[0][1], res11[0][0], res11[0][1]},
                {res10[1][0], res10[1][1], res11[1][0], res11[1][1]}};
    }

    //correct
    private int[][] sum(int[][] a, int[][] b) {
        int[][] resultMatrix = new int[a.length][a.length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                resultMatrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultMatrix;
    }


    private int[][][] partitionOf4x4Matrix(int[][] b) {
        return new int[][][]{
                {{b[0][0], b[0][1]}, {b[1][0], b[1][1]}},
                {{b[0][2], b[0][3]}, {b[1][2], b[1][3]}},
                {{b[2][0], b[2][1]}, {b[3][0], b[3][1]}},
                {{b[2][2], b[2][3]}, {b[3][2], b[3][3]}}};
    }

    //correct
    private int[][] inv(int[][] a) {
        int[][] result = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = -a[i][j];
            }
        }
        return result;
    }

}
