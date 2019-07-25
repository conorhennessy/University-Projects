// Commented version of program - Submitted by 1703055

import java.util.*;


/// Point class for the creation of point objects.
/// Point Objects have the attributes of x and y
/// Parameters taken of x and y in the Constructor which is called when an object is instantiated, in order to create the object
/// Overrides the toString() method to form a nice output for as required to show the Point
class Point {
    int x, y;

    public Point(int x, int y) { // Constructor which is called when Point objects are instantiated.  Declaring the attributes associated with the object
        this.x = x;
        this.y = y;
    }

    // Override the toString method so that when toString is called for the Point object this will be Called rather than the default toString method for objects
    @Override
    public String toString() {
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}


/// Points And Scores class for the creation of an object to associate the score value of a position together
//  >                                                            Where the score is a heuristic value on the current game move and how advantageous the move would be
/// PointsAndScores object has attributes of score and point
/// Parameters of a score and a Point object taken by the constructor - where the constructor will be called when the object is instantiated, to create the object
/// No methods within this class
class PointsAndScores {
    int score;
    Point point;

    PointsAndScores(int score, Point point) {  // Constructor which is called when PointsAndScores objects are instantiated.  Declaring the attributes associated with the object
        this.score = score;
        this.point = point;
    }
}

/// Anonymous Board class for the creation the whole board object
/// (As it is anonymous there are no associated attributes or a constructor here)
/// Many methods called for the game functions which modify the board.
/// Please see to individual methods to understand all the aspects of the board thoroughly.
class Board {
    // Initialising three variables for the board and methods use.
    List<Point> availablePoints;  // initialising a list, which will be used to store all points on the board which are available to place on. Used in getAvailablePoints() method.
    Scanner scan = new Scanner(System.in); // initialising a scanner
    int[][] board = new int[3][3];  // initialing a multidimensional array in order to define the whole board and the state of each board point.
                                    // Each board point will take one of 3 values - 0 for no placement, 1 for AI placement & 2 for User placement. Placement being if a player has placed their piece in a board place
                                    // Please see to displayMethod() method for how this assignment of values is converted to a user friendly view with naughts and crosses for output

    public Board() {  // An empty class with no constructor, no constructor is necessary it just has lots of methods
    }

    /// Method to see if either AI or User has won  OR  if there are no longer any more points to place.  Used to understand the end state of the game and if the program has reached it.
    //  Return: true if AI or User has won  OR  if there are no longer any more points available to place. Else false
    public boolean isGameOver() { return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty()); }

    /// Method to check if the X player (AI) has won by completing any of the lines across the board; may it be diagonal, horizontal or vertical
    /// Returns a Boolean : True if AI player has won by completing a full line in any direction. Else False
    public boolean hasXWon() {
        //If conditional to check the two diagonals of the board, to see if AI player has won
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;  // If conditional to check the diagonals. If the all the values in the diagonal lines in the array are equal to 1, AI has won so returns true
        }
        for (int i = 0; i < 3; ++i) {  // Loop to check columns OR rows. To see if AI has won in the rows or columns
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;  // If the all the values in row or column i are equal to 1, AI has won so returns true
            }
        }
        return false;  // Otherwise this method returns false as none of the lines (diagonal, row or column) are complete with 1 values for X (AI) to have won
    }

    /// Method to check if the O player (User) has won across the board. The same procedure of checking as the hasXWon() method but now checking for array values of two to see if the user has won. For commenting sake, I will also outline the systems workings here
    /// Returns a Boolean : True if user player has won by completing a full line in any direction. Else False.
    public boolean hasOWon() {
        // The following checks the two diagonals of the board, to see if User player has won
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
             return true; // If conditional to check the diagonals. If the all the values in the diagonal lines in the array are equal to 2, User has won so returns true
        }
        for (int i = 0; i < 3; ++i) { // Loop to check columns OR rows. To see if User has won in the rows or columns
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true; // If the all the values in row or column i are equal to 2, User has won so returns true
            }
        }
        return false; // Otherwise the method returns false as none of the lines (diagonal, row or column) are complete with 2 values for O (User) to have won
    }

    /// Method which creates an array of all points which are available for a move to placed at. If a place has a condition of Zero (0) the point is added to this list.  Used to update the availablePoints list after point placement by player
    /// Returns a List<Point>:  The updated availablePoints List
    public List<Point> getAvailablePoints() {
        availablePoints = new ArrayList<>();  // Create an array list, which is used to store all points on the board which are available to place on.
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) { // With a nested for loop which iterates through the whole board array
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j)); // If x,y point of the board is empty (not placed on) the position is added to availablePoints array
                }
            }
        }
        return availablePoints; // The available Points array is returned so the min max search knows where is available to place
    }

    /// Method which returns what the state of a particular point of the board is.  Will return 1,2,0 dependant on what positions are placed
    /// Returns an int: a value showing the state of the board point at x,y. 1 for an X placement for AI, 2 for an ) placement for User or 0 for a blank point (one that has not been placed on)
    public int getState(Point point){ return board[point.x][point.y]; }

    /// Method which updates the multidimensional board array in position [x][y] in the array with the players move (a value of 1 or 2 )
    /// No Return as void: Updates the board list itself, often called before other methods as it is updating the board
    public void placeAMove(Point point, int player) { board[point.x][point.y] = player; }

    /// Method which draws the current board to the console by iterating through the board array, with current User and AI moves shown
    /// No return as void: Simply prints the board to console, imagine it as a fancy toString() method for the board array
    public void displayBoard() {
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
