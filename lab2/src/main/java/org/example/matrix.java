package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class matrix {
    //описання класу матриця
    private int rows;
    private int columns;
    private double[][] data;
    //Виведення матриці
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println(); // Перехід на новий рядок після кожного рядка матриці
        }
    }

    //створення матриці
    matrix(){
        this.rows = 0;
        this.columns = 0;
        this.data = new double[0][0];
    }
    matrix(int rows, int columns){
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Not correct input");
        }
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }
    matrix(matrix old) {
        this.rows = old.rows;
        this.columns = old.columns;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = old.data[i][j];
            }
        }
    }
    matrix(double[][] old) {
        this.rows = old.length;
        this.columns = old[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = old[i][j];
            }
        }
    }

    //3.Додати методи, що дозволяють заповнити матрицю значеннями
    public void fill_one(int row, int column, double value) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid matrix element access.");
        }
        data[row][column] = value;
    }

    public void fill(double[][] values) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = values[i][j];
            }
        }
    }
    public void fillRandom() {
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double randomValue = rand.nextInt(20)+1;
                data[i][j] = randomValue;
            }
        }
    }

    // 4. Додати методи, що дозволяють отримати заданий елемент, рядок чи стовпчик
    public double get_element(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid matrix element access.");
        }
        return data[row][column];
    }

    public double[] get_row(int row) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid matrix row access.");
        }
        return data[row];
    }

    public double[] get_column(int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Invalid matrix column access.");
        }
        double[] res_column = new double[rows];
        for (int i = 0; i < rows; i++) {
            res_column[i] = data[i][column];
        }
        return res_column;
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public List<Integer> getDimension(){
        int rows  = getRows();
        int columns = getColumns();
        List<Integer> dimension = new ArrayList<Integer>();
        dimension.add(rows);
        dimension.add(columns);
        return dimension;
    }
    //6. Визначити методи equals/hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof matrix)) return false;
        if (obj instanceof ImmutableMatrix) return false;
        matrix other = (matrix) obj;
        if (this.hashCode()!= obj.hashCode()) return false;
        return Arrays.deepEquals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }
    public static matrix Add(matrix matrix1, matrix matrix2) {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            throw new IllegalArgumentException("Not correct matrix input");
        }
        ;
        matrix resault = new matrix(matrix1.getRows(), matrix1.getColumns());
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                resault.data[i][j] = matrix1.get_element(i, j) + matrix2.get_element(i, j);
            }
        }
        return resault;
    }

    public static matrix multiplication_scalar(matrix matrix, int scalar) {
        matrix resault = new matrix(matrix);
        if (matrix.getRows() < 0 || matrix.getColumns() < 0) {
            throw new IllegalArgumentException("Invalid matrix element access.");
        }
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                resault.data[i][j] = matrix.get_element(i, j) * scalar;
            }
        }
        return resault;
    }

    //9. Реалізують операцію множення матриць
    public matrix multiplication_matrix(matrix matrix2) {
        if (this.getColumns() != matrix2.getRows()) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }

        matrix result = new matrix(this.getRows(), matrix2.getColumns());

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                double sum = 0;
                for (int k = 0; k < this.getColumns(); k++) {
                    sum += this.get_element(i, k) * matrix2.get_element(k, j);
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }

    //10. Повертають транспоновану матрицю
    public matrix trans_matrix() {
        if (this.rows <= 0 || this.columns <= 0) {
            throw new IllegalArgumentException("Invalid matrix dimensions.");
        }

        matrix result = new matrix(this.columns, this.rows);
        for (int i = 0; i < this.rows; i++) {
            if (this.data[i].length != this.columns) {
                throw new IllegalArgumentException("Matrix rows have inconsistent column counts.");
            }
            for (int j = 0; j < this.columns; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }
    //11. Діагональну матрицю (на основі задано вектора)
    public matrix createDiagonalMatrix(double[] vector) {
        int size = vector.length;
        matrix diagonalMatrix = new matrix(size,size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    diagonalMatrix.data[i][j] = vector[i];
                } else {
                    diagonalMatrix.data[i][j] = 0.0;
                }
            }
        }

        return diagonalMatrix;
    }
    //12. Одиничну матрицю
    public static matrix createIdentityMatrix(int size) {
        matrix identityMatrix = new matrix(size,size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    identityMatrix.data[i][j] = 1.0;
                } else {
                    identityMatrix.data[i][j] = 0.0;
                }
            }
        }
        return identityMatrix;
    }
    //13. Матрицю-строку, заповнену випадковими значеннями
    public static matrix createRandomRow(int size) {
        matrix row = new matrix(1,size);
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            double randomValue = rand.nextInt(10) + 1;
            row.data[0][i] = randomValue;
        }

        return row;
    }
    //14. Матрицю-стовпчик, заповнену випадковими значеннями
        public static matrix createRandomColumn(int size) {
            matrix column = new matrix(size, 1);
            Random rand = new Random();

            for (int i = 0; i < size; i++) {
                double randomValue = rand.nextInt(10) + 1;
                column.data[i][0] = randomValue;
            }

            return column;
        }
        //15. Створення оберненої матриці
    public matrix inverseMatrix() {
        if (rows != columns) {
            throw new IllegalArgumentException("Матриця повинна бути квадратною для знаходження оберненої матриці.");
        }

        double determinant = determinant(data);
        if (determinant == 0) {
            throw new IllegalArgumentException("Матриця є сингулярною, обернена матриця не існує.");
        }

        matrix inverse = new matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix minorMatrix = createMinorMatrix(i, j);
                double minorDeterminant = determinant(minorMatrix.data);
                double cofactor = Math.pow(-1, i + j) * minorDeterminant;
                inverse.data[j][i] = cofactor / determinant;
            }
        }

        return inverse;
    }

    // Метод для створення мінорної матриці
    private matrix createMinorMatrix(int row, int col) {
        matrix minorMatrix = new matrix(rows - 1, columns - 1);

        for (int i = 0, newRow = 0; i < rows; i++) {
            if (i == row) continue;
            for (int j = 0, newCol = 0; j < columns; j++) {
                if (j == col) continue;
                minorMatrix.data[newRow][newCol] = data[i][j];
                newCol++;
            }
            newRow++;
        }

        return minorMatrix;
    }
    // Приватний статичний метод для обчислення детермінанта матриці
    private static double determinant(double[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < n; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        }

        return det;
    }
    // метод для отримання мінорної матриці
    private static double[][] minor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];

        for (int i = 0, p = 0; i < n; i++) {
            if (i != row) {
                for (int j = 0, q = 0; j < n; j++) {
                    if (j != col) {
                        minor[p][q++] = matrix[i][j];
                    }
                }
                p++;
            }
        }

        return minor;
    }
}






