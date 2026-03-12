package sin;

public class MathSeries {

    public static double sinSeries(double x, double eps) {
        if (eps <= 0.0) {
            throw new IllegalArgumentException("eps must be positive");
        }

        x = x % (2 * Math.PI);

        double term = x;
        double sum = 0.0;
        int k = 0;
        int maxIterations = 100000;

        while (Math.abs(term) > eps && k < maxIterations) {
            sum += term;
            k++;

            double numerator = -1.0 * x * x;
            double denominator = (2 * k) * (2 * k + 1);
            term = term * numerator / denominator;
        }

        return sum;
    }
}
