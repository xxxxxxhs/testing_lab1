package sin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathSeriesTest {
    // TODO вынести константой епс и группы эквивалентности
    @Test
    public void testSinSeriesAtZero() {
        double x = 0.0;
        double eps = 1e-10;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void testSinSeriesAtPiOverTwo() {
        double x = Math.PI / 2;
        double eps = 1e-8;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-7);
    }

    @Test
    public void testSinSeriesAtMinusPiOverTwo() {
        double x = -Math.PI / 2;
        double eps = 1e-8;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-7);
    }

    @Test
    public void testSinSeriesAtPi() {
        double x = Math.PI;
        double eps = 1e-8;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-7);
    }

    @Test
    public void testSinSeriesAtSmallX() {
        double x = 1e-3;
        double eps = 1e-12;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-12);
    }

    @Test
    public void testSinSeriesAtMediumX() {
        double x = Math.PI / 4;
        double eps = 1e-8;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-7);
    }

    @Test
    public void testSinSeriesAtLargeX() {
        double x = 10 * Math.PI;
        double eps = 1e-6;

        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, eps);

        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void testSinSeriesInvalidEpsZero() {
        double x = 1.0;
        double eps = 0.0;

        assertThrows(IllegalArgumentException.class, () -> MathSeries.sinSeries(x, eps));
    }

    @Test
    public void testSinSeriesInvalidEpsNegative() {
        double x = 1.0;
        double eps = -1e-3;

        assertThrows(IllegalArgumentException.class, () -> MathSeries.sinSeries(x, eps));
    }
}