package life;

public class Generation {

     Generation(GameOfLife window, Board grid) throws InterruptedException {
        while (true) {
            generateThread generateThread = new generateThread(window, grid);
            window.setThread(generateThread);
            generateThread.start();
            generateThread.sleep(5000);
        }
    }

    class generateThread extends Thread {

        Board grid;
        GameOfLife window;

        generateThread(GameOfLife window, Board grid) {
            this.grid = grid;
            this.window = window;
        }

        @Override
        public void run() {
            while (true) {
                if (!window.isPaused) {
                    grid.incrementGeneration();
                    generateOneLife(grid);
                    window.updateDisplay(grid, grid.generation);
                }
                try {
                    Thread.sleep(15000L);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

            }
        }

    }

    void generateOneLife(Board grid) {
        int gridSize = grid.N;
        boolean[][] nextGen = new boolean[gridSize][gridSize];


        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                int countOfNeighbors = 0;

                int rowSouth = row + 1 >= gridSize ? 0 : row + 1;
                int rowNorth = row - 1 < 0 ? gridSize - 1: row - 1;
                int colEast = col + 1 >= gridSize ? 0 : col + 1;
                int colWest = col - 1 < 0 ? gridSize - 1 : col - 1;


                if (grid.getCell(rowNorth, colWest)) {
                     countOfNeighbors++; // NW cell
                   }
                if (grid.getCell(rowNorth, col)) {
                    countOfNeighbors++; // N cell
                }
                if (grid.getCell(rowNorth, colEast)) {
                    countOfNeighbors++; // NE cell
                }
                if (grid.getCell(row, colWest)) {
                    countOfNeighbors++; // W cell
                }
                if (grid.getCell(row, colEast)) {
                    countOfNeighbors++; // E cell
                }
                if (grid.getCell(rowSouth, colWest)) {
                    countOfNeighbors++; // SW cell
                }
                if (grid.getCell(rowSouth, col)) {
                    countOfNeighbors++; // S cell
                }
                if (grid.getCell(rowSouth, colEast)) {
                    countOfNeighbors++; // SE cell
                }

                nextGen[row][col] = false;
                if (grid.getCell(row, col) && countOfNeighbors >= 2 && countOfNeighbors <= 3) {
                    nextGen[row][col] = true;
                } else if (!grid.getCell(row, col) && countOfNeighbors == 3) {
                    nextGen[row][col] = true;
                }
            }
        }
        grid.copyGrid(nextGen);

    }
}
