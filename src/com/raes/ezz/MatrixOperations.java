package com.raes.ezz;

import java.util.Scanner;

public class MatrixOperations {
    private int dimensionMatrix = 0;

    public int[][] createSquareMatrix(){
        Scanner in = new Scanner(System.in);
        if (dimensionMatrix == 0){
            System.out.println("----------Set dimension to matrix nxn----------");
            dimensionMatrix = in.nextInt();
        }else{
            System.out.println("----------Your matrix dimension is " + dimensionMatrix + "x" + dimensionMatrix + "----------");
        }
        int matrix[][] = new int[dimensionMatrix][dimensionMatrix];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.println("----------Set number to position " + "(" + i + "," + j + ")" +"----------");
                int number = in.nextInt();
                matrix[i][j] = number;
            }
        }
        return matrix;
    }

    public int[][] matrixSum(int[][] a, int[][] b){
        if (!validate(a,b)){
            return null;
        }
        int[][] result = new int[dimensionMatrix][dimensionMatrix];
        for (int i = 0; i < dimensionMatrix; i++){
            for (int j = 0; j < dimensionMatrix; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public int[][] matrixSubtraction(int[][] a, int[][] b){
        if (!validate(a,b)){
            return null;
        }
        int[][] result = new int[dimensionMatrix][dimensionMatrix];
        for (int i = 0; i < dimensionMatrix; i++){
            for (int j = 0; j < dimensionMatrix; j++){
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public int[][] matrixMultiply(int[][] a, int[][] b) {
        if (!validate(a,b)){
            return null;
        }
        int[][] result = new int[dimensionMatrix][dimensionMatrix];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    private boolean validate(int[][] a, int[][] b){
        if (dimensionMatrix == 0 || a.length != b.length){
            System.out.println("Error: For use this function, this class need dimensions. Try use createSquareMatrix() function for create your arrays.");
            return false;
        }
        return true;
    }

    public void printMatrix(int[][] matrix,String title){
        if (matrix == null){
            System.out.println("Error: The matrix with title '" + title + "' is null.");
        }else {
            System.out.println("----------" + title + "----------");
            System.out.println("Your matrix is: ");
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("|");
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(" " + matrix[i][j] + " ");
                }
                System.out.println("|");
            }
        }
    }

}
