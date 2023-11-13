package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MatrixTest {

    @Test
    public void testMatrixCreation() {
        matrix mat = new matrix(3, 3);
        assertNotNull(mat);
        assertEquals(3, mat.getRows());
        assertEquals(3, mat.getColumns());
    }

    @Test
    public void testMatrixEquality() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix mat1 = new matrix(data);
        matrix mat2 = new matrix(data);
        assertTrue(mat1.equals(mat2));
    }

    @Test
    public void testMatrixAddition() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};
        matrix mat1 = new matrix(data1);
        matrix mat2 = new matrix(data2);

        matrix result = matrix.Add(mat1, mat2);
        double[][] expected = {{6, 8}, {10, 12}};
        matrix expectedResult = new matrix(expected);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testMatrixScalarMultiplication() {
        double[][] data = {{1, 2}, {3, 4}};
        matrix mat = new matrix(data);

        matrix result = matrix.multiplication_scalar(mat, 2);
        double[][] expected = {{2, 4}, {6, 8}};
        matrix expectedResult = new matrix(expected);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testMatrixMultiplication() {
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};
        matrix mat1 = new matrix(data1);
        matrix mat2 = new matrix(data2);

        matrix result = mat1.multiplication_matrix(mat2);
        double[][] expected = {{19, 22}, {43, 50}};
        matrix expectedResult = new matrix(expected);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testMatrixTranspose() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        matrix mat = new matrix(data);

        matrix result = mat.trans_matrix();
        double[][] expected = {{1, 4}, {2, 5}, {3, 6}};
        matrix expectedResult = new matrix(expected);

        assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testMatrixInverse() {
        double[][] data = {{4, 7}, {2, 6}};
        matrix mat = new matrix(data);

        matrix result = mat.inverseMatrix();
        double[][] expected = {{0.6, -0.7}, {-0.2, 0.4}};
        matrix expectedResult = new matrix(expected);

        assertTrue(result.equals(expectedResult));
    }
    @Test
    public void testCreateDiagonalMatrix() {
        double[] vector = {1, 2, 3};
        matrix diagonalMatrix = new matrix().createDiagonalMatrix(vector);

        double[][] expected = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        matrix expectedMatrix = new matrix(expected);

        assertTrue(diagonalMatrix.equals(expectedMatrix));
    }

    @Test
    public void testCreateIdentityMatrix() {
        int size = 4;
        matrix identityMatrix = matrix.createIdentityMatrix(size);

        double[][] expected = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        matrix expectedMatrix = new matrix(expected);

        assertTrue(identityMatrix.equals(expectedMatrix));
    }

    @Test
    public void testCreateRandomRow() {
        int size = 5;
        matrix randomRow = matrix.createRandomRow(size);

        assertEquals(1, randomRow.getRows());
        assertEquals(size, randomRow.getColumns());

        for (int i = 0; i < size; i++) {
            assertTrue(randomRow.get_element(0, i) >= 1 && randomRow.get_element(0, i) <= 10);
        }
    }

    @Test
    public void testCreateRandomColumn() {
        int size = 3;
        matrix randomColumn = matrix.createRandomColumn(size);

        assertEquals(size, randomColumn.getRows());
        assertEquals(1, randomColumn.getColumns());

        for (int i = 0; i < size; i++) {
            assertTrue(randomColumn.get_element(i, 0) >= 1 && randomColumn.get_element(i, 0) <= 10);
        }
    }
    @Test
    public void testInvalidMatrixElementAccess() {
        try {
            matrix mat = new matrix(3, 3);
            mat.get_element(3, 2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixRowAccess() {
        try {
            matrix mat = new matrix(2, 2);
            mat.get_row(3);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixColumnAccess() {
        try {
            matrix mat = new matrix(2, 2);
            mat.get_column(2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixAddition() {
        try {
            matrix mat1 = new matrix(2, 3);
            matrix mat2 = new matrix(3, 2);
            matrix.Add(mat1, mat2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixMultiplication() {
        try {
            matrix mat1 = new matrix(2, 3);
            matrix mat2 = new matrix(4, 2);
            mat1.multiplication_matrix(mat2);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixTranspose() {
        try {
            matrix mat = new matrix(0, 4);
            mat.trans_matrix();
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testInvalidMatrixInverse() {
        try {
            double[][] singularMatrixData = {{1, 2}, {2, 4}};
            matrix singularMatrix = new matrix(singularMatrixData);
            singularMatrix.inverseMatrix();
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
        }
    }
}
