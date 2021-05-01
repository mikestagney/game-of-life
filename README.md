# Game of Life

John Conway's Game of Life using Swing and multithreading

## Things learned

Created a graphical user interface (GUI) with Swing, first time using it.

Multithreading - first time working with it in Java.

### Details

Simple rules of the game: A cell with 2 or 3 neighbors survives to the next generation; otherwise, it dies of boredom (<2) or overpopulation (>3). A dead cell is reborn if it has exactly 3 neighbors.

Main difference from other versions of the game is that border cells have eight neighbors. The screen wraps around to determine if the border cells have enough neighbors to stay alive for the next generation.

Model-view-controller design pattern used to structure the project.

Passed all unit tests for completion but the multithreading timing is not working correctly.  When users start and stop the program, the pause button doesn't immediately stop the game and once it's restarted, it speeds up so fast that it skips displaying many of the generations.  I will come back to fix this project after I have learned more about multithreading.

Seventh project created for JetBrains Academy Java Developer course - It was a medium level project when I built it but JetBrains changed it to a hard level project.

#### The directory contains 4 files: 

* Main.java - Sets up Board and GameOfLife objects
* Board.java - Maintains the game board data - the model
* GameOfLife.java - Displays and updates the game board display with Swing - the view
* Generation.java - Generates threads, updated Board data for one life generation and checks for pause and reset button clicks - the controller

### How to play

The game starts automatically with cells randomly alive or dead.  The user can either pause the game or reset the board to a new random configuration. The game keeps track of the number of cells alive and the number of generations.

### Sample input and output:

![screenshot](https://github.com/mikestagney/game-of-life/blob/main/Game%20of%20Life.png)
