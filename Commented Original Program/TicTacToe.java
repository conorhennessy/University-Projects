// Commented version of program - Submitted by 1703055

import java.util.*;

public class
TicTacToe {

    public static void main(String[] args) {
        AIplayer AI = new AIplayer();  //TODO talk about the initiation of these vars once you know about the AI code more
        Board b = new Board();
        Point p = new Point(0, 0);
        Random rand = new Random();

        b.displayBoard();  //   Calls the method which draws the current board to the console

        System.out.println("Who makes first move? (1)Computer (2)User: ");
        // User input is taken and if user selects computer first, AI takes a turn
        // This consists of AI picks a place by calling callMinimax method, the output all points and scores potential places
        // Then place the move in the best position by calling placeAMove method (so updates Board array) and then print the board out
        int choice = b.scan.nextInt();
        if (choice == 1) {
            AI.callMinimax(0, 1, b);
            for (PointsAndScores pas : AI.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }

            b.placeAMove(AI.returnBestMove(), 1);
            b.displayBoard();
        }

        // The main body of the game alternating between user being requested for move and AI making placement
        while (!b.isGameOver()) { // Loop while game is not over by isGameOver() method, if it returns true, break out - returns true when there no more possible moves or if one of the players won

            /// USER'S TURN
            System.out.println("Your move: line (1, 2, or 3) column (1, 2, or 3)");
            Point userMove = new Point(b.scan.nextInt() - 1, b.scan.nextInt() - 1);  // take users two separate int inputs as x, y values and map to a Point object
            // Error handling: while their selection is a point on the board that is already full, ask them for their move again.
            while (b.getState(userMove) != 0) {
                System.out.println("Invalid move. Make your move again: ");
                userMove.x = b.scan.nextInt() - 1;
                userMove.y = b.scan.nextInt() - 1;
            }

            // Place the user's move in the User's position by calling placeAMove method (so updates Board array) and then print the board out
            b.placeAMove(userMove, 2);  //   Calls method to place user's move (which is a point obj.) on the board array
            b.displayBoard();  //  As a new piece has been placed on the board, show board to console

            if (b.isGameOver()) {  // Check if game is over by isGameOver() method, if returns true break out - is there no more possible moves or has one of the players won?
                break;
            }


            /// AI'S TURN
            // This consists of AI picking a place by calling callMinimax method, then output all points and scores potential places by looping through
            // Then place the move in the best position by calling placeAMove method (so updates Board array) and then print the board out
            AI.callMinimax(0, 1, b);
            for (PointsAndScores pas : AI.rootsChildrenScores) {
                System.out.println("Point: " + pas.point + " Score: " + pas.score);
            }
            // Place the AI's move in the best position by calling placeAMove method (so updates Board array) and then print the board out again
            b.placeAMove(AI.returnBestMove(), 1);
            b.displayBoard();
        }

        // End game reached so determine outcome, who has won...
        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}