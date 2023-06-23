import java.util.*;

public class alphaMan {

    // global variables and arrays
    static int n,m;                           // maze size N x M
    static char[][] maze = new char[20][20];  // current maze,
                                              //   create a board of size 20 which is the max value of N
    static int rowAM, colAM;                  // Alphaman's position in maze
    static int rowExit, colExit;              // Exit position in maze
    static int rowTarget, colTarget;          // The new position after the move
    static int gemCount;
    static int finish;                        // status of the game - {-1:in progress,0:game finished}
    static char curMove;                      // player's move

    static Scanner scan = new Scanner (System.in);  // scanner that will used in the entire code

    static void setupGame() {
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String row = scan.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = row.charAt(j);
                if (maze[i][j] == 'A') {
                    rowAM = i;
                    colAM = j;
                }
                if (maze[i][j] == 'E') {
                    rowExit = i;
                    colExit = j;
                }
                if (maze[i][j] == 'G') {
                    gemCount++;
                }
            }
        }
        finish = -1;
    }

    static void drawScreen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println("Remaining gems: " + gemCount);
        System.out.println();
    }

    static void getMove() {
        System.out.println("Enter move: ");
        rowTarget = rowAM;
        colTarget = colAM;
        curMove = scan.next().charAt(0);
        if (curMove == 'u') {
            rowTarget--;
        } else if (curMove == 'd') {
            rowTarget++;
        } else if (curMove == 'l') {
            colTarget--;
        } else if (curMove == 'r') {
            colTarget++;
        }
        if (maze[rowTarget][colTarget] == 'G') {
            gemCount--;
        }
        while (maze[rowTarget][colTarget] == '#'|| curMove != 'u' && curMove != 'd' && curMove != 'l' && curMove != 'r' || maze[rowTarget][colTarget] == 'E' && gemCount > 0) {
            rowTarget = rowAM;
            colTarget = colAM;
            System.out.println("Invalid move!");
            System.out.println("Enter move: ");
            curMove = scan.next().charAt(0);
            if (curMove == 'u') {
                rowTarget--;
            } else if (curMove == 'd') {
                rowTarget++;
            } else if (curMove == 'l') {
                colTarget--;
            } else if (curMove == 'r') {
                colTarget++;
            }
            if (maze[rowTarget][colTarget] == 'G') {
                gemCount--;
            }
        }
    }

    static void makeMove() {
        if (maze[rowTarget][colTarget] != 'M') {
            maze[rowAM][colAM] = '.';
            maze[rowTarget][colTarget] = 'A';
            rowAM = rowTarget;
            colAM = colTarget;
        } else {
            maze[rowAM][colAM] = '.';
        }
    }

    static int checkEndGame() {
        if (rowAM == rowExit && colAM == colExit) {
            return 0;
        } else if (maze[rowTarget][colTarget] == 'M') {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {

        setupGame();                        // STEP 1

        // main game loop
        while (true) {
            drawScreen();                   // STEP 2
            getMove();                      // STEP 3
            makeMove();                     // STEP 4
            finish = checkEndGame();        // STEP 5
            if (finish>-1) break;            // if game is finished, break the loop
        }
        
        drawScreen();
        if (finish == 0) {
            System.out.println("Congrats, you finished!!!");
        } else if (finish == 1) {
            System.out.println("You lost!!!");
        }
    }
}
