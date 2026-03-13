package sin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathSeriesTest {
    private static final double EPS = 1e-8;
    private static final double DELTA = 1e-7;

    @Test
    public void testSinSeriesAtZero() {
        double x = 0.0;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtPiOverTwo() {
        double x = Math.PI / 2;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtMinusPiOverTwo() {
        double x = -Math.PI / 2;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtPi() {
        double x = Math.PI;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtSmallX() {
        double x = 1e-3;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtMediumX() {
        double x = Math.PI / 4;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testSinSeriesAtLargeX() {
        double x = 10 * Math.PI;
        double expected = Math.sin(x);
        double actual = MathSeries.sinSeries(x, EPS);
        assertEquals(expected, actual, DELTA);
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
        double eps = -EPS;

        assertThrows(IllegalArgumentException.class, () -> MathSeries.sinSeries(x, eps));
    }

    @Test
    public void testSinSeriesEquivalenceClassZero() {
        double[] xs = {0.0, Math.PI, -Math.PI, 2 * Math.PI};
        for (double x : xs) {
            double expected = Math.sin(x);
            double actual = MathSeries.sinSeries(x, EPS);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testSinSeriesEquivalenceClassPositive() {
        double[] xs = {Math.PI / 6, Math.PI / 4, Math.PI / 3, 0.5};
        for (double x : xs) {
            double expected = Math.sin(x);
            double actual = MathSeries.sinSeries(x, EPS);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testSinSeriesEquivalenceClassNegative() {
        double[] xs = {-Math.PI / 6, -Math.PI / 4, -Math.PI / 3, -0.5};
        for (double x : xs) {
            double expected = Math.sin(x);
            double actual = MathSeries.sinSeries(x, EPS);
            assertEquals(expected, actual, DELTA);
        }
    }
}