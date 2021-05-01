package life;



public class Main {
    public static void main(String[] args) throws Exception {
        //UserInput input = new UserInput();

        Board board = new Board();
        GameOfLife window = new GameOfLife(board); //took out board
        Generation generate = new Generation(window, board);
        //Generation.generates(window, board);

        //Thread t1 = new Thread(() -> new GameOfLife());

        //t1.start();
        //t1.sleep(50000);

    }


        //Board grid = new Board(input.N);


        //Generation.generates(15, grid);

        //Output.printToConsole(grid);
    }

