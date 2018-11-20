// Commented version of program - Submitted by 1703055

import java.util.*;  // Import of the package (classes) required. Here importing all classes from the util folder.  where util if the utility classes

class AIplayer {  //  Star of the class declaration stating the name of the object as AIplayer
    List<Point> availablePoints; // Initiating of the availablePoints List which only take the Point object type only (the Point object is constructed within the Board Class)  -  the variable is used for
    List<PointsAndScores> rootsChildrenScores;  // Initiation of the rootsChildrenScores List which takes PointsAndScores object type only (this object is constructed within the Board Class) -  the variable is used for
    Board b = new Board(); // Create a new Board object to initiate the lists for the availablePints and the multidimensional array of the board itself and the various board variables now available to access
    
    public AIplayer() { // An empty class with no constructor, no constructor is necessary it just has lots of methods
    }

    /// Method to find the best value move in all the scores stored in the rootsChildrenScores list. Which is a list of all the root node scores calculated in the minimax method
    /// Returns a Point from the list at position i
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

    /// A method to find the minimum value in the supplied List.
    /// Arguments taken: a list of Integers = a list of all the scores given during the minimax function
    /// Returns an int: the smallest value found in the List
    public int returnMin(List<Integer> list) { // Method declared as a public access method called return min which takes an List of Integers as only input and will return an int
        int min = Integer.MAX_VALUE;  // Initiating a int variable to hold the minimum value in the supplied List.  Here the variable is default set to integer.MAX_VALUE the maximum value possible an int can have (of 2^31 - 1). This is done so that when comparison is made the conditional will definitely triggered with whatever int is found, as a value compared to this will always be bigger
        int index = -1;  // An int which will be used to hold the location of the minimum value within the supplied List
        
        for (int i = 0; i < list.size(); ++i) {  // Simple for loop. Initialising with an int value of 0 for i which will increment up by one each time it loops. This for loop will stop running when i reaches the size of the supplied List
            if (list.get(i) < min) {  // Conditional to see if the Integer in current (i) position in the supplied List is smaller than the current min value found
                min = list.get(i); // If so the min variable is replaced with the Integer retrieved at i position in the supplied List
                index = i;         // Also the index variable is updated with the index location (i) in the supplied List where the min has been found
            }
        }
        return list.get(index); // Finally the method returns an int, the smallest value in the provided List. By retrieving the value in the supplied List at index i
    }

    /// A method to find the maximum value in the supplied List.  Very similar to the returnMin() method, however simply works in the opposite way in order to find the max value.  for commenting sake, I will continue to outline how it works with each line.
    /// Arguments taken: a list of Integers = a list of all the scores given during the minimax function
    /// Returns an int: the maximum value found in the List
    public int returnMax(List<Integer> list) { // Method declared as a public access method called return max which takes an List of Integers as only input and will return an int
        int max = Integer.MIN_VALUE; // Initiating a int variable to hold the minimum value in the supplied List.  Here the variable is default set to integer.MIN_VALUE the minim value possible an int can have (of -2^31). This is done so that when comparison is made the conditional will definitely be triggered with whatever int is found, as a value compared to this will always be bigger
        int index = -1; // An int which will be used to hold the location of the minimum value within the supplied List
        
        for (int i = 0; i < list.size(); ++i) {  // Simple for loop. Initialising with an int value of 0 for i which will increment up by one each time it loops. This for loop will stop running when i reaches the size of the supplied List
            if (list.get(i) > max) {  // Conditional to see if the Integer in current (i) position in the supplied List is bigger than the current min value found
                max = list.get(i);    // If the Int in position i is greater than the current max value, the max variable is replaced with the Integer retrieved at position i in the supplied List
                index = i;            // Also the index variable is updated with the index location (i) in the supplied List where the min has been found
            }
        }
        return list.get(index);  // To finish the method returns an int which is the biggest value in the List. By retrieving the value in the supplied List at index i
    }

    /// A method to simply call the following Minimax function
    /// Arguments taken: an integer for the depth = initially this starts as 0 and with each recursion of the function it increments up
    ///                  an int = denoting who's turn it is currently placing. 1 if it's the AI turn OR 2 if it's the Users current turn
    ///                  a Board obj. = the whole board object is taken by the method and so it has access to the available points list and the board array itself
    /// No Return as void: simply creates an array list for the root's children scores and then calls the minimax function, which does return the max or min of a particular move depending on who's go it is
    public void callMinimax(int depth, int turn, Board b){  // Method declared as a public access called call minimax which takes a number of arguments (outlined above) of depth, turn and the board object
        rootsChildrenScores = new ArrayList<>();  //Initiating an Array List which will be used to store the scores for the root nodes of the tree
        minimax(depth, turn, b);  // Call the minimax method in order to start the iterative  search method  to evaluate many nodes.
    }

    /// A method to run the minimax search algorithm, an algorithm which creates a game tree to evaluate all the nodes at each depths based on the end game outcomes.
    /// Arguments taken: an integer for the depth = initially this starts as 0 and with each recursion of the function it increments up
    ///                  an int = denoting who's turn it is currently placing. 1 if it's the AI turn OR 2 if it's the Users current turn
    ///                  a Board obj. = the whole board object is taken by the method and so it has access to the available points list and the board array itself
    public int minimax(int depth, int turn, Board b) {  // Method declared as a public method called minimax which takes a number of arguments (outlined above here) in o
        if (b.hasXWon()) return 1;  // Conditional checking if the AI player has won, by calling the hasXWon method which checks if any of the lines are completely filled with Xs. Returns 1 as the AI has won, and so it is the most vavorable value, so high 1
        if (b.hasOWon()) return -1;  // Conditional if where if the User player has won, by calling the hasOWon method which checks if any of the lines are completely filled with OS. Returns -1 as the User would win with this move, which is the least favorable and so it returns a negative 1
        List<Point> pointsAvailable = b.getAvailablePoints();  // Call the getAvailablepoints() method in order to find all the points which a move can still be placed on. The result of this method is mapped to the pointsAvailable Lists which takes Point objects
        if (pointsAvailable.isEmpty()) return 0;   // Finally if there are no points available the pointsAvailable list is empty and so return 0; as there are no available moves.  This value of zero is not good or bad, it shows that this state (or move) isnt of interest as it would lead to a draw.

        List<Integer> scores = new ArrayList<>();  // Initiating an ArrayList used to hold the scores for each of nodes

        for (int i = 0; i < pointsAvailable.size(); ++i) {  // Simple for loop. Looping throgh all the empt spaces in the board.  Initialising with an int value of 0 for i which will increment up by one each time it loops. This for loop will stop running when i reaches the size of the pointsAvsilable List
            Point point = pointsAvailable.get(i);  // Initiating a point variable of type Point to hold a single point. By getting the point at index i of the pointsAvailable List.  This is used as the position to consider placing a move at

            if (turn == 1) {  // If it is the AI's turn, so continue the mini max search method testing what the options are for the AI turn
                b.placeAMove(point, 1);  // Now place a piece temporary move on this point of the board. As player 1 (AI) a X will be placed at the x & y of the point supplied
                int currentScore = minimax(depth + 1, 2, b);  // Here evaluate what the score of the node board is with selecting this position to make a move.  This is done by calling the minimax method again as this is a recursive function to loop  through until one of the return criteria is met.   Where a value will be returned evaluating the move
                scores.add(currentScore);   // Add the current socre of the current node to the scores list, for use with comparison
                if (depth == 0)  // With recursion of the minimax function , it will reach a point where the depth is 0 and so recursion is finished for this root node. where the depth is originaly passed from callMinimax
                    rootsChildrenScores.add(new PointsAndScores(currentScore, point));  // So the current score for the point is added to the roots scores list.
                
            } else if (turn == 2) {  // Else if it is the Users current turn, so with the mini max search method we want to see what is available as an option for the player
                b.placeAMove(point, 2);  // Places a temporary move for the 'user' at point position
                scores.add(minimax(depth + 1, 1, b));  // Here evaluate what the score of the node board is with selecting this position to make a move.  This is done by calling the minimax method again as this is a recursive function to loop  through until one of the return criteria is met.   Where a value will be returned evaluating the move
            }

            b.placeAMove(point, 0);  // After all the point that has been selected for testing is 'reset' by placing the blank " . " move in the position
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);  // Following the principle of the minimax search method if it is the AIs go return this boards max score here from the current depth level to be passed on. Found by calling the returnMax() method.  Else the min score is returned
    }    
}
