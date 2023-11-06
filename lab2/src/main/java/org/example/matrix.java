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
        matrix other = (matrix) obj;
        return Arrays.deepEquals(data, other.data);
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
    public static matrix calculateInverseMatrix(matrix inputMatrix) {
        int n = inputMatrix.getRows();
        double[][] matrixData = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixData[i][j] = inputMatrix.get_element(i, j);
            }
        }
        matrix augmentedMatrix = new matrix(n, 2 * n);
        // Створення початкового розширеного матриці [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix.fill_one(i, j, matrixData[i][j]);
                augmentedMatrix.fill_one(i, j + n, (i == j) ? 1.0 : 0.0);
            }
        }
        // метод Гаусса-Джордана
        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix.get_element(i, i);

            if (pivot == 0.0) {
                System.err.println("Matrix is singular (not invertible).");
                return null;
            }

            for (int j = 0; j < 2 * n; j++) {
                double value = augmentedMatrix.get_element(i, j) / pivot;
                augmentedMatrix.fill_one(i, j, value);
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix.get_element(k, i);
                    for (int j = 0; j < 2 * n; j++) {
                        double newValue = augmentedMatrix.get_element(k, j) - factor * augmentedMatrix.get_element(i, j);
                        augmentedMatrix.fill_one(k, j, newValue);
                    }
                }
            }
        }
        // Вилучення оберненої матриці [I | A^(-1)]
        matrix inverseMatrix = new matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix.fill_one(i, j, augmentedMatrix.get_element(i, j + n));
            }
        }
        return inverseMatrix;
    }
 }


