// Commented version of program - Submitted bt 1703055

import java.util.*;


/// Point class for the creation of point objects.
/// Object has attributes of x and y
/// Overrides the tostring() method to form a nice output for as required to show the Point
/// Parameters taken of x and y to
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // TODO Override the toString method ...
    @Override
    public String toString() {
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}

class PointsAndScores {
    int score;
    Point point;

    PointsAndScores(int score, Point point) {  ///
        this.score = score;
        this.point = point;
    }
}

class Board { 
    List<Point> availablePoints;
    Scanner scan = new Scanner(System.in);
    int[][] board = new int[3][3];

    public Board() {
    }

    public boolean isGameOver() { return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty()); }  /// Method to see if either AI or User has won  OR  if there are no longer any more points to place.  Can be used to understand the end state of the game

    public boolean hasXWon() {  /// Method to check if the X player (AI) has won in any of the lines across the board
        //If conditional to check the two diagonals of the board, to see if AI player has won
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;  // If conditional to check the diagonals. If the all the values in the diagonal lines in the array are equal to 1, AI has won so returns true
        }
        for (int i = 0; i < 3; ++i) {  // Loop to check rows and columns. To see if AI has won in the rows or columns
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;  // If the all the values in row or column i are equal to 1, AI has won so returns true
            }
        }
        return false;  // Otherwise this method returns false as none of the lines (diagonal, row or column) are complete with 1 values for X (AI) to have won
    }

    public boolean hasOWon() { /// Method to check if the O player (User) has won across the board. The same procedure of checking as the hasXWon() method but now checking for array values of two to see if the user has won for commenting sake, I will also outline the system here
        // Statement to check the two diagonals of the board, to see if User player has won
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
             return true; // If conditional to check the diagonals. If the all the values in the diagonal lines in the array are equal to 2, User has won so returns true
        }
        for (int i = 0; i < 3; ++i) { // Loop to check rows and columns. To see if User has won in the rows or columns
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true; // If the all the values in row or column i are equal to 2, User has won so returns true
            }
        }
        return false; // Otherwise the method returns false as none of the lines (diagonal, row or column) are complete with 2 values for O (User) to have won
    }

    public List<Point> getAvailablePoints() {  /// Method which creates an array of all points which are available for a move to placed at.
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) { // With a nested for loop which iterates through the whole board array
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j)); // If x,y point of the board is empty (not placed on) the position is added to availablePoints array
                }
            }
        }
        return availablePoints; // The available Points array is returned so the min max search knows where is available to place
    }
    
    public int getState(Point point){ return board[point.x][point.y]; }  /// Method which returns what the state of a particular point of the board is.  Will return 1,2,0 dependant on what positions are placed

    public void placeAMove(Point point, int player) { board[point.x][point.y] = player; }  /// Method which updates the multidimensional board array with the players move (a value of 1 or 2 ) in point position x,y

    public void displayBoard() {  /// Method which draws the current board to the console by iterating through the board array, with current User and AI moves shown
        System.out.println();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {  // With a nested for loop which iterates through the whole board array
                    // The following collection of conditionals here outputs the appropriate character for each place on the board
                    if (board[i][j]==1)
                        System.out.print("X "); // Out X for AI
                    else if (board[i][j]==2)
                        System.out.print("O "); // Out O for User
                    else
                        System.out.print(". "); // Out . for place that is blank
                }
            System.out.println();  // Print a new line for loop to then goto the next row of the board
        }
    }
}
