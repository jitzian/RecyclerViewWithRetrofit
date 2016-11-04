package net.sgoliver.android.navigationdrawer.exercises;

import java.util.Scanner;

/**
 * Created by User on 10/31/2016.
 */

public class MatrixMultiplication {

    public static void main(String...args){
        int matrix[][];
        System.out.print("Type number of matrix: ");
        Scanner in = new Scanner(System.in);
        int mtrxNum = in.nextInt();

        matrix = new int[mtrxNum + 1][mtrxNum + 1];

        for(int i = 1; i <= mtrxNum; i ++){
            for(int j = 1; j <= mtrxNum; j ++){
                matrix[i][j] = i*j;
//                System.out.print((matrix[i][j] = i*j) + " ");
                if(i%2 == 0 && j%2 == 0){
                    matrix[i][j] = 10;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



    }

}
