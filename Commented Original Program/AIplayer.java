// Commented version of program - Submitted by 1703055

import java.util.*;  // Import of the package (classes) required. Here importing all classes from the util folder.  where util if the utility classes

class AIplayer {  //  Star of the class declaration stating the name of the object as AIplayer
    List<Point> availablePoints; // Initiating of the availablePoints List which only take the Point object type only (the Point object is constructed within the Board Class)  -  the variable is used for
    List<PointsAndScores> rootsChildrenScores;  // Initiation of the rootsChildrenScores List which takes PointsAndScores object type only (this object is constructed within the Board Class) -  the variable is used for
    Board b = new Board(); // Create a new Board object to initiate the lists for the availablePints and the multidimensional array of the board itself and the various board variables now available to access
    
    public AIplayer() { //TODO note an empty class?
    }

    /// Method to find the best value move in TODO all this method
    /// Returns a list:
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
    /// Arguments taken: an integer for the depth = TODO actually explain what this depth var is doing
    ///                  an int = denoting who's turn it is currently placing. 1 if it's the AI turn OR 2 if it's the Users current turn
    ///                  a Board obj. = the whole board object is taken by the method and so it has access to the available points list and the board array itself
    /// No Return as void: simply creates an array list for the root's children scores and then calls the minimax function, which does return the max or min of a particular move depending on who's go it is
    public void callMinimax(int depth, int turn, Board b){  // Method declared as a public access called call minimax which takes a number of arguments (outlined above) in order TODO what is this acc doing?
        rootsChildrenScores = new ArrayList<>();  //Initiating an Array List which will be used to store the scores TODO what is this storing :(
        minimax(depth, turn, b);  // Call the minimax method in order to calculate and find the
    }
    
    public int minimax(int depth, int turn, Board b) {
        if (b.hasXWon()) return 1;
        if (b.hasOWon()) return -1;
        List<Point> pointsAvailable = b.getAvailablePoints();
        if (pointsAvailable.isEmpty()) return 0; 

        List<Integer> scores = new ArrayList<>(); 

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);  

            if (turn == 1) { 
                b.placeAMove(point, 1); 
                int currentScore = minimax(depth + 1, 2, b);  
                scores.add(currentScore); 
                if (depth == 0) 
                    rootsChildrenScores.add(new PointsAndScores(currentScore, point));
                
            } else if (turn == 2) {
                b.placeAMove(point, 2); 
                scores.add(minimax(depth + 1, 1, b));  
            }
            b.placeAMove(point, 0); 
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }    
}
