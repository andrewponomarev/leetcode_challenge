package daily._2020._08.week_2._09;

import java.util.LinkedList;
import java.util.List;

public class RottingOranges {

    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    public static void main(String[] args) {
        int[][] grid = {{0, 2}};;
        System.out.println(new RottingOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.ROWS = grid.length;
        this.COLS = grid[0].length;

        boolean isThereFreshOranges = false;

        List<Triple<Integer, Integer, Integer>> rottenOranges = new LinkedList<>();
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Triple(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    isThereFreshOranges = true;
                }
            }
        }

        if (!isThereFreshOranges) {
          §  return 0;
        }
        if (rottenOranges.isEmpty()) {
            return -1;
        }

        int max = -1;
        for (Triple<Integer, Integer, Integer> pair : rottenOranges) {
            max = Math.max(this.BFS(grid, pair.first, pair.second), max);
        }
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return max;
    }

    protected int BFS(int[][] board, int r, int c) {
        LinkedList<Triple<Integer, Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Triple<>(r, c, 0));
        int maxMins = -1;

        while (!queue.isEmpty()) {

            Triple<Integer, Integer, Integer> pair = queue.pollFirst();
            int row = pair.first, col = pair.second, mins = pair.third;
            if (board[row][col] != 1 && mins != 0)
                continue;
            board[row][col] = 2;
            maxMins = Math.max(maxMins, mins);
            if (col < this.COLS - 1)
                queue.offer(new Triple<>(row, col + 1, mins + 1));
            if (row < this.ROWS - 1)
                queue.offer(new Triple<>(row + 1, col, mins + 1));
            if (col > 0)
                queue.offer(new Triple<>(row, col - 1, mins + 1));
            if (row > 0)
                queue.offer(new Triple<>(row - 1, col, mins + 1));
        }
        return maxMins;
    }
}

class Triple<U, V, Z> {
    public U first;
    public V second;
    public Z third;

    public Triple(U first, V second, Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
