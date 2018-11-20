//You are supposed to add your comments

import java.util.*;

class AIplayer { 
    List<Point> availablePoints;
    List<PointsAndScores> rootsChildrenScores;
    Board b = new Board();
    
    public AIplayer() {
    }
    
    public Point returnBestMove() {
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < rootsChildrenScores.size(); ++i) { 
            if (MAX < rootsChildrenScores.get(i).score) {
                MAX = rootsChildrenScores.get(i).score;
                best = i;
            }
        }
        return rootsChildrenScores.get(best).point;
    }

    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
 
    public void callMinimax(int depth, int turn, Board b, int depthLimit){
        rootsChildrenScores = new ArrayList<>();
        minimax(depth, turn, b, depthLimit);
    }

    public int heuristicsCalculation(Board b){
        int heuristicValue = 0;

        // A heuristics based function to look at each of the lines (rows, columns and diagonals) and see how good each of the lines are.
        // All to calculate a heuristicsValue of all the various lines to judge how 'good' the current board being supplied is
        // checks all the lines in the oard where the following criteria effect the heuristic value
        //                how many X in line? Add up how many there are, more the better so a positive impact on the heuristic val
        //                how many O in line? Add up how many there are, less the better so sum a negative number on the heuristic val
        // NOTE             IF row has 3 naughts, they are getting close and so I should be particularly interested in a board which blocks them
        //                If it has a mix just ignore it, we are not interested about this line any more, add 0

        // Start with all the rows and columns with this nested for loop system to search through the multidimensional array
        for (int i = 0; i < 5; ++i) {
            int rowNumberOfX = 0;
            int rowNumberOfO = 0;
            int colNumberOfX = 0;
            int colNumberOfO = 0;
            int diaNumberOfX = 0;

            // check i row & column and the contents of
            for (int j = 0; j < 5; ++j){

                if (b.board[j][i] == 1) {   //Does row also contain an X?  If so we should be interested in this row and so has a positive impact on the heuristic in the end
                    ++rowNumberOfX;
                }
                if (b.board[j][i] == 2) {  //Does row also contain an O?  If so we should tend away from this row and so has a positive negative on the heuristic in the end
                    ++rowNumberOfO;
                }

                if (b.board[i][j] == 1) {
                    ++colNumberOfX;
                }
                if (b.board[i][j] == 2) {
                    ++colNumberOfO;
                }


                //If there is a mix of values in the row or col break out from this col as this is not a col of interest
                if ( (rowNumberOfO > 0 && rowNumberOfX > 0) || (colNumberOfO > 0 && colNumberOfX > 0) ){
                    break;
                }

                else {  //Calculate a heuristic value for this i row and column
                    //Add to the heuristic value by using the following formula which is based on a score of the number of crosses in all the cols being good and all the
                    heuristicValue += rowNumberOfX - rowNumberOfO;
                    heuristicValue += colNumberOfO - colNumberOfO;
                }

            }

            // If i row or i col has 3 naughts and a single cross now, the AI should be really interested in this move
            if ( (rowNumberOfO == 3  && rowNumberOfX == 1) || (colNumberOfO == 3 && colNumberOfX == 1) ) {
                heuristicValue = 50;
            }

            // Then check the two diagonals in the board, how are the doing with the criteria? Influence the heuristic as necessary
            if (b.board[i][i] == 1){
                heuristicValue += diaNumberOfX;
            }
            if (b.board[4-i][4-i] == 1){
                heuristicValue += diaNumberOfX;
            }

        }

        if (b.hasXWon()){
            heuristicValue = 1000;
        }

        return heuristicValue;
    }


    public int minimax(int depth, int turn, Board b, int depthLimit) {  // Now method passes an extra argument to know at what depth to stop at

        if (b.hasXWon()) return 1;
        if (b.hasOWon()) return -1;
        List<Point> pointsAvailable = b.getAvailablePoints();
        if (pointsAvailable.isEmpty()) return 0;

        // Introducing a max depth limit for the minimax function, when minimax hits the depth limit - complete heuristics
        if (depth == depthLimit){
            return heuristicsCalculation(b);
        }

        List<Integer> scores = new ArrayList<>(); 

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);  

            if (turn == 1) { 
                b.placeAMove(point, 1); 
                int currentScore = minimax(depth + 1, 2, b, depthLimit);
                scores.add(currentScore); 
                if (depth == 0) 
                    rootsChildrenScores.add(new PointsAndScores(currentScore, point));
                
            } else if (turn == 2) {
                b.placeAMove(point, 2); 
                scores.add(minimax(depth + 1, 1, b, depthLimit));
            }
            b.placeAMove(point, 0); 
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }    
}
