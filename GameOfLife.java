package life;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameOfLife extends JFrame {

    JToggleButton playButton;
    JButton resetButton;
    JPanel sidePanel;
    JLabel generationDisplay;
    JLabel aliveDisplay;
    JPanel gridSection;
    JPanel[][] cells;
    Thread thread;
    boolean isPaused = false;

    public GameOfLife(Board board) {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);

        // text section
        sidePanel = new JPanel();
        sidePanel.add(Box.createRigidArea(new Dimension(0, 30)));

        playButton = new JToggleButton("Stop");
        playButton.setName("PlayToggleButton");
        sidePanel.add(playButton);
        resetButton = new JButton("Reset");
        resetButton.setName("ResetButton");
        sidePanel.add(resetButton);

        sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        generationDisplay = new JLabel();
        generationDisplay.setText("Generation #21");
        generationDisplay.setName("GenerationLabel");
        sidePanel.add(generationDisplay);

        sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));
        aliveDisplay = new JLabel();
        aliveDisplay.setText("Alive: 14");
        aliveDisplay.setName("AliveLabel");
        sidePanel.add(aliveDisplay);

        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        add(sidePanel, BorderLayout.WEST);
        gridSection = new JPanel();

        resetButton.addActionListener(e -> board.resetBoard());
        playButton.addActionListener(e -> {
            if (playButton.isSelected()) {
                isPaused = true;
                playButton.setText("Start");
            } else {
                isPaused = false;
                playButton.setText("Stop");
            }
        });

        int size = 170;
        cells = new JPanel[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new JPanel();
                cells[i][j].setBackground(Color.BLACK);
                cells[i][j].setOpaque(true);
                gridSection.add(cells[i][j]);
            }
        }

        gridSection.setLayout(new GridLayout(board.N, board.N));
        add(gridSection, BorderLayout.CENTER);
        setVisible(true);

    }
    public void setThread(Thread thread) {
        this.thread = thread;
    }



    public void updateDisplay(Board board, int generation) {

        int gridSize = board.N;

        for(int row = 0; row< gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                cells[row][col].setOpaque(board.grid[row][col]);
            }
        }
        generationDisplay.setText("Generation #" + generation);
        aliveDisplay.setText("Alive: " + board.getAliveCount(board.grid));
        repaint();
    }

}
