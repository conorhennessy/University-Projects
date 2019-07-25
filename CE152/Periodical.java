package ass;

import org.junit.*;
import static ass.Exercise2.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TestExercise2 {
    int[][] array = {{3, -1, 4, 0}, {5, 9, -2, 6}, {5, 3, 7, -8}};

    @Test
    public void testSum() {
        assertEquals(31, sum(array));
    }

    @Test
    public void testRowSums() {
        int[] exp = {6, 18, 7};
        assertArrayEquals(exp, rowSums(array));
    }

    @Test
    public void testColumnSums() {
        int[] exp = {13, 11, 9, -2};
        assertArrayEquals(exp, columnSums(array));
    }

    @Test
    public void testMaxRowAbsSum() {
        assertEquals(23, maxRowAbsSum(array));
    }
}