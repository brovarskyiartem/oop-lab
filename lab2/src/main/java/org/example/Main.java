package org.example;
import java.util.Arrays;
import static org.example.matrix.*;

public class Main {
    public static void main(String[] args){
      //Заповнення матриці
        /*    //Пуста матриця
                matrix matrix_1 = new matrix();
                matrix_1.printMatrix(); */
       /*      //Матриця заданого розміру
                matrix matrix_1 = new matrix(2,2);
                matrix_1.fillRandom();
                matrix_1.printMatrix();
                ImmutableMatrix matrix_2 = new ImmutableMatrix(matrix_1);
                matrix_2.printMatrix();
                System.out.println(matrix_1.equals(matrix_2));
                matrix_1.fill_one(1,1,-100);
                matrix_1.printMatrix();
                Add(matrix_1,matrix_2).printMatrix();/*
            //Матриця за данними
                double[][] data = {{1,2},{3,4},{5,6}};
                matrix matrix_3 = new matrix(data);*/
   /*     //Отримати елемент, рядок, стовбчик
        System.out.println("Рядок" + Arrays.toString(matrix_2.get_row(1)));
        System.out.println("Стовбчик" + Arrays.toString(matrix_2.get_column(1)));
        System.out.println("Елемент" + matrix_2.get_element(1,1));*/
       /* //Розмірність матриці
        System.out.println((matrix_2.getDimension()));*/
    /*    //Створення Immutable матриці
        ImmutableMatrix immutable =  new ImmutableMatrix(matrix_2);
        immutable.fill_one(1,1,10);*/
     /*   //Додавання матриць
        matrix matrix1 = new matrix(2,2);
        matrix1.fillRandom();
        matrix matrix2 = new matrix(2,2);
        matrix2.fillRandom();
        System.out.println("Перша матриця");
        matrix1.printMatrix();
        System.out.println("Друга матриця");
        matrix2.printMatrix();
        System.out.println("Результат додавайння");
        Add(matrix1,matrix2).printMatrix();
        System.out.println("Результат множення на скаляр");
        multiplication_scalar(matrix1,2).printMatrix();*/
/*        //Множення матриць
        matrix matrix1 = new matrix(2,2);
        matrix1.fillRandom();
        matrix matrix2 = new matrix(2,2);
        matrix2.fillRandom();
        System.out.println("Перша матриця");
        matrix1.printMatrix();
        System.out.println("Друга матриця");
        matrix2.printMatrix();
        System.out.println("Результат множення");
        (matrix1.multiplication_matrix(matrix2)).printMatrix();*/
         /*//Транспонування
          matrix matrix1 = new matrix(3,3);
          matrix1.fillRandom();
          System.out.println("Початкова матриця");
          matrix1.printMatrix();
          System.out.println("Транспонована матриця");
          (matrix1.trans_matrix()).printMatrix();*/
     /*   //Діагональна матриця
        double[] diagonalVector = {1.0, 2.0, 3.0};
        int i = 0;
        int len = diagonalVector.length;
        for (int j = 0; j< len; j++){
            i+=1;
        }
        matrix matrix1 = new matrix(i,i);
        (matrix1.createDiagonalMatrix(diagonalVector)).printMatrix();*/
       /* //Одинична матриця
        createIdentityMatrix(4).printMatrix();*/
/*
        //отримання матриці строки та матриці рядка
        createRandomRow(2).printMatrix();
        createRandomColumn(3).printMatrix();
*/
        //Перетворення в обернену матрицю
        double[][] data = {{1,1,2}, {1, 2,1},{5,6,3}};
        matrix matrix_2 = new matrix(3,3);
        matrix_2.fill(data);
        ImmutableMatrix matrix_1 = new ImmutableMatrix(matrix_2);
        System.out.println(matrix_2.equals(matrix_2));
        System.out.println("Початкова матриця");
        matrix_1.printMatrix();
        System.out.println("Результуюча матриця");
        ImmutableMatrix res = new ImmutableMatrix(calculateInverseMatrix(matrix_1));
        res.printMatrix();
    }
}
