package ass;

import java.util.Arrays;

public class Exercise2 {
    public static int sum(int[][] array) {
        int sum = 0;
        for (int[] anArray : array) {
            for (int j = 0; j < anArray.length; j++) {
                sum += anArray[j];
            }
        }
        return sum;
    }

    public static int[] rowSums(int[][] array) {
        int [] rowsSum = new int[3];
        for (int i = 0; i < array.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                rowSum += array[i][j];
            }
            rowsSum[i] = rowSum;
        }
        return rowsSum;
    }

    public static int[] columnSums(int[][] array) {
        int [] columnsSums = new int[4];
        int j = 0;
        while (j < array[0].length) {
            for (int i = 0; i < array.length; i++) {
                columnsSums[j] += array[i][j];
            }
            j++;
        }
        return columnsSums;
    }

    public static int maxRowAbsSum(int[][] array) {
        int [] absRowsSum = new int[3];
        for (int i = 0; i < array.length; i++) {
            int absRowSum = 0;
            for (int j = 0; j < array[i].length; j++) {
                absRowSum += Math.abs(array[i][j]);
            }
            absRowsSum[i] = absRowSum;
        }
        Arrays.sort(absRowsSum);
        return absRowsSum[absRowsSum.length - 1];
    }


    public static void main(String[] args) {
        System.out.println("Exercise 2 - Conor Hennessy - ch17811");

        int[][] array = {{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}};

        //Part A
        System.out.println("\nPart A:\nSum of array: " + sum(array));
        //Part B
        System.out.println("\nPart B:\nSum of rows: " + Arrays.toString(rowSums(array)));
        //Part C
        System.out.println("\nPart C:\nSum of columns: " + Arrays.toString(columnSums(array)));
        //Part D
        System.out.println("\nPart D:\nArray maximum absolute row value: " + maxRowAbsSum(array));
    }
}