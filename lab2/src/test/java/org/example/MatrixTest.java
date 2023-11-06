package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testMatrixFillOne() {
        matrix testMatrix = new matrix(3,3);
        testMatrix.fill_one(1, 2, 10);
        assertEquals(10, testMatrix.get_element(0, 1), 0.001); // Перевірка заповнення конкретного елемента
    }

    @Test
    public void testMatrixDiagonalMatrix() {
        double[] diagonalVector = {1.0, 2.0, 3.0};
        matrix testMatrix = new matrix(3,3);
        matrix diagonalMatrix = testMatrix.createDiagonalMatrix(diagonalVector);
        double[][] data = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        matrix expectedMatrix = new matrix(3,3);
        expectedMatrix.fill(data);
        assertEquals(expectedMatrix, diagonalMatrix);
    }

    @Test
    public void testMatrixIdentityMatrix() {
        double[][] testData = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix testMatrix = new matrix(3,3);
        testMatrix.fill(testData);
        int size = 4;
        matrix identityMatrix = testMatrix.createIdentityMatrix(size);

        double[][] data = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        matrix expectedMatrix = new matrix(4,4);
        expectedMatrix.fill(data);

        assertEquals(expectedMatrix, identityMatrix);
    }

 /*   @Test
    public void testMatrixInverseMatrix() {
        double[][] testData = {{2, 3}, {1, 4}};
        matrix testMatrix = new matrix(2,2);
        testMatrix.fill(testData);

        matrix inverseMatrix = matrix.calculateInverseMatrix(testMatrix);

        double[][] expectedResult = {{4.0 / 5.0, -3.0 / 5.0}, {-1.0 / 5.0, 2.0 / 5.0}};
        matrix expectedMatrix = new matrix(2,2);
        expectedMatrix.fill(expectedResult);

        assertEquals(expectedMatrix, inverseMatrix);
    }*/
}
