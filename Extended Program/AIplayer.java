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
    
    public int minimax(int depth, int turn, Board b, int depthLimit) {  // Now method passses an extra argument to know at what depth to stop at

        if (b.hasXWon()) return 1;
        if (b.hasOWon()) return -1;
        List<Point> pointsAvailable = b.getAvailablePoints();
        if (pointsAvailable.isEmpty()) return 0; 

        // Introducing a max depth limit for the minimax function, to exit this recursion
        if (pointsAvailable.size() == depthLimit){
            // TODO Break out?
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
