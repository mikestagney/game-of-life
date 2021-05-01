package life;

import java.util.Random;

public class Board {

    boolean[][] grid;
    private Random random;
    final public int N = 170;
    public int generation;


    Board() {
        resetBoard();
    }
    public void copyGrid(boolean[][] nextGen) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                grid[row][col] = nextGen[row][col];
            }

        }

    }
    public boolean getCell(int row, int col) {
        return grid[row][col];
    }

    public void incrementGeneration() {
        generation++;
    }

    public int getAliveCount(boolean[][] grid) {

        int aliveCount = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (grid[row][col]) {
                    aliveCount++;
                }
            }
        }
        return aliveCount;
    }
    public void resetBoard() {
        this.grid = new boolean[N][N];
        this.random = new Random();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                grid[row][col] = random.nextBoolean();
            }
        }
        generation = 0;

    }



}
