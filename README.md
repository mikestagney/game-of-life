# Game of Life

John Conway's Game of Life using Swing and multithreading

## Things learned

Created GUI with Swing, first time using it.

Multithreading - first time

### Details

Main difference from other versions is that border cells also have eight neighbors. This uses screen wrap around to determine if the cell has enough neighbors to stay alive for the next generation.

Seventh project created for JetBrains Academy Java Developer course - hard level project.

Passed all unit tests for completion but the multithreading timing is not working correctly when users starts and stops the program.

#### The directory contains 4 files: 

* Main.java - Sets up Board and GameOfLife objects
* Board.java - Maintains the game board data
* GameOfLife.java - Displays and updated the game board display with Swing
* Generation.java - Generates threads, updated Board data for one life generation and checks for pause and reset button clicks 

### How to play

The game starts automatically with random cells alive or dead.  The user can either pause the game or reset the board to a new random configuration. The game keeps track of the number of cells alive and the number of generations.

### Sample input and output:

![screenshot](https://github.com/mikestagney/game-of-life/blob/main/Game%20of%20Life.png)
