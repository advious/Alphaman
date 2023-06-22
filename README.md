# Alphaman
A text-based maze game made with Java.

## Rules:

Alphaman is a one-player game. After creating a maze, Alphaman's position, and the exit location, the player leads Alphaman to the exit.
The player uses the following keys to move:

- `u`: up
- `d` : down
- `l`: left
- `r`: right

The game ends whenever Alphaman reaches the exit.

## Game Design:

N (number of rows) and M (number of columns) will be entered then the maze will be inputted as a matrix. The maze contains the following characters:
- `#` - wall
- `.` - empty spots
- `A` - Alphaman
- `E` - exit
- `G` - gems
- `M` - monsters

Sample Setup:

```
8 7
#######
#..#G.#
##...M#
#M.#.E#
#..#..#
#.##.G#
#A...M#
#######
```

In each turn, the current maze is shown on the screen. Then the program waits for the player input (`u`, `d`, `l`, or `r`) and makes the move. The game finishes whenever Alphaman reaches the exit.
