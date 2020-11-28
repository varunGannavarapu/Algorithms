/* *****************************************************************************
 *  Name:              Varun Gannavarapu
 *  Last modified:     24 Nov. 2020
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private boolean[][] full;
    private int size;
    private WeightedQuickUnionUF wuf;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        size = n;
        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;  // true is open, false is blocked
            }
        }
        wuf = new WeightedQuickUnionUF(n * n); // define our weighted union
        for (int i = 0; i < n; i++) {
            wuf.union(0, i); // create virtual top site
        }
        for (int i = n * n - n; i < n * n; i++) {
            wuf.union(n * n - n, i); // create virtual bottom site
        }
        openSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) {
            return;
        }
        grid[row - 1][col - 1] = true;
        openSites++;
        /* Connect the neighbors if open */
        if (col < size && isOpen(row, col + 1)) { // right
            wuf.union((row - 1) * size + (col - 1), (row - 1) * size + col);
        }
        if (col - 2 >= 0 && isOpen(row, col - 1)) { // left
            wuf.union((row - 1) * size + (col - 1), (row - 1) * size + (col - 2));
        }
        if (row < size && isOpen(row + 1, col)) { // bottom
            wuf.union((row - 1) * size + (col - 1), row * size + (col - 1));
        }
        if (row - 2 >= 0 && isOpen(row - 1, col)) { // top
            wuf.union((row - 1) * size + (col - 1), (row - 2) * size + (col - 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException();
        }
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException();
        }
        return ((wuf.find((row - 1) * size + (col - 1)) == wuf.find(0)) && isOpen(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return wuf.find(0) == wuf.find(size * size - 1); // is top connected to bottom
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
