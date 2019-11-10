/*
Project 1: Matrix Operation
Created By: Sangat Shah
Created On: 09-15-18
Last Modified: 10-22-18
*/
package lab.pkg1.matrixop;

import java.util.Scanner;


public class Driver {
    
    static Scanner scan = new Scanner(System.in);
    
    public static Matrix getMatrix(String name)
    {
        System.out.println("Give the Parameters for The" + name + "Matrix: ");
        System.out.print("Enter the Number of Rows: ");
        int row = scan.nextInt();
        System.out.println();
        System.out.print("Enter the Number of Columns: ");
        int col = scan.nextInt();
        return new Matrix(row,col);
    }
    
    public static Matrix performOperation(Matrix A, Matrix B, int selection)
    {
        switch(selection)
        {
            case 1:
                return A.add(B);
            case 2:
                return A.subtract(B);
            case 3:
                return A.dotProduct(B);
            default:
                return A.hadamardProduct(B);
        }
    }
    
    public static int doOperation()
    {
        System.out.println("What Matrix Operation would you like to perform?");
        System.out.println("Enter:\n"
                + " 1. Addition \n"
                + " 2. Subtraction \n"
                + " 3. Dot Product \n"
                + " 4. Hadamard Product \n"
                + "");
        int selection = scan.nextInt();
        return selection;

    }
    
    
    public static Matrix calculate(Matrix A, Matrix B)
    {
        boolean isValid = false;
        
        int selection = doOperation();
        do 
        {
        if(selection == 1 || selection == 2 || selection == 4)
        {
            isValid = Matrix.validateSubAddHad(A,B);
        }
        else if (selection == 3)
        {
            isValid = Matrix.validateDot(A,B);
        }
        else {
            isValid = false;
        }
        }
        while(!isValid);
        
        return performOperation(A, B, selection);
    }
    
    public static boolean isValidOp(int selection, Matrix A, Matrix B)
    {
        switch (selection)
        {
            case 1:
                return Matrix.validateSubAddHad(A, B);
            case 2:
                return Matrix.validateSubAddHad(A, B);
            case 3:
                return Matrix.validateDot(A, B);
            case 4:
                return Matrix.validateSubAddHad(A, B);
            default:
                return false;
        }
        
        
        
        
    }
    
    
    
    public static void main(String[] args)
    {
        
        Matrix A = getMatrix(" First ");
        System.out.println(A.toString());
        Matrix B = getMatrix(" Second ");
        System.out.println(B.toString());
        Matrix C = Driver.calculate(A,B);
        System.out.println(" RESULT: ");
        System.out.println(C.toString());
        
        
    }
    
}
