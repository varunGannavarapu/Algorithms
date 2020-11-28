/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int T;  // trials
    private double[] data;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        T = trials;
        data = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(n);
            double count = 0;
            while (!p.percolates()) {
                p.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
                count++;
            }
            data[i] = (count) / Math.pow(n, 2);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(data);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(data);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mn = mean();
        double std = stddev();
        return mn - (1.96 * std) / Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mn = mean();
        double std = stddev();
        return mn + (1.96 * std) / Math.sqrt(T);
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats sts = new PercolationStats(Integer.parseInt(args[0]),
                                                    Integer.parseInt(args[1]));
        StdOut.println("mean = " + sts.mean());
        StdOut.println("stddev =" + sts.stddev());
        StdOut.println("95% confidence interval = [" + sts.confidenceLo() + ", " +
                               sts.confidenceHi() + "]");

    }
}
