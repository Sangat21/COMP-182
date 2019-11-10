/*
Project 1: Matrix Operation
Created By: Sangat Shah
Created On: 09-15-18
Last Modified: 10-23-18
*/
package lab.pkg1.matrixop;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;


public class Matrix 
{
    private final int row;
    private final int col;
    private final int [][] elements;
    
    public Matrix(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.elements = IntStream.range(0, row).mapToObj(x 
                -> new Random().ints(-100,100).limit(col).toArray()).toArray(int [][] :: new);
    }
    
    
    public static boolean validateSubAddHad(Matrix A, Matrix B)
    {
        return (A.row == B.row && A.col == B.col);
    }
    
    public static boolean validateDot(Matrix A, Matrix B)
    {
        return (A.col == B.row);
    }
    
    public Matrix(int [][] input)
    {
        this.row = input.length;
        this.col = input.length;
        this.elements = Arrays.stream(input).map(x 
                -> Arrays.copyOf(x,x.length)).toArray(int [][] :: new);
    
    }
    
    public Matrix add(Matrix input)
    {
      return new Matrix(IntStream.range(0,this.row).mapToObj(x
                ->IntStream.range(0, this.col).map(y
                ->this.elements[x][y] + input.elements[x][y]).toArray()).toArray(int [][] :: new));
    }
    
    public Matrix subtract(Matrix input) 
    {
        return new Matrix(IntStream.range(0,this.row).mapToObj(x
                ->IntStream.range(0, this.col).map(y
                ->this.elements[x][y] - input.elements[x][y]).toArray()).toArray(int [][] :: new));
    }
    
    public Matrix dotProduct(Matrix input)
    {
        return new Matrix(IntStream.range(0,this.row).mapToObj(i
                ->IntStream.range(0, input.col).map(j
                        ->IntStream.range(0, this.col).map(k-> this.elements[i][k]*input.elements[k][j]).reduce(0,(a,b)
                                ->a + b)).toArray()).toArray(int [][] :: new));
    }
    
    public Matrix hadamardProduct(Matrix input)
    {
        return new Matrix(IntStream.range(0,this.row).mapToObj(x
                ->IntStream.range(0, this.col).map(y
                ->this.elements[x][y] * input.elements[x][y]).toArray()).toArray(int [][] :: new));
    }
    
    
    
    @Override
    public String toString()
    {
        return Arrays.stream(this.elements).map(r->Arrays.stream(r).mapToObj(e
                ->String.format("%6d", e)).reduce(" ", (a,b) -> a + b))
                .reduce("", (a,b) -> a + b + '\n');
    }
    
    public boolean equals(Object Obj)
    {
        if (Obj instanceof Matrix)
        {
            Matrix input = (Matrix)Obj;
            return Arrays.deepEquals(this.elements, input.elements);
        }
        else
        {
            return false;
        }
    }
    
  
    @Override
    public Object clone()
    {
        return (Object) new Matrix (this.elements);
    }
    
}