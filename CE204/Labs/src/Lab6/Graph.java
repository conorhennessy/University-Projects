public class Graph {
    private int numNodes;

    // vertices will be called A,B,...

    // adjacency list representation used
    // adjLists[0] will hold a reference to the first cell in a linked list containing
    //       details of the edges from A to all of its neighbours,
    // adjLists[1] will hold details of edges from B to its neighbours etc.

    private ListCell[] adjLists;

    // constructor to create a graph with n vertices and no edges
    public Graph(int n) {
        int i;
        numNodes = n;
        adjLists = new ListCell[n];
        for (i = 0; i < n; i++)
            adjLists[i] = null;
    }

    // try to add an edge (v1,v2) with weight w) - return true if successful, false otherwise
    public boolean addEdge(char v1, char v2, int w) { // convert the vertex names into array positions
        int pos1 = v1 - 'A';
        int pos2 = v2 - 'A';

        // check if either of pos1 and pos2 is outside the array index range
        if ((pos1 >= adjLists.length || pos2 >= adjLists.length) || (pos1 < 0 || pos2 < 0)) {
            System.out.println("pos1 or pos2 is outside the array index range");
            return false;
        } else if (v1 == v2) {
            System.out.println("vertices must be distinct");
            return false;
        }
        else if (neighbours(v1, v2)) {
            System.out.println("edge is already present");
            return false;
        } else {
            // add a new cell with values (v2,w) to the front of the list adjLists[pos1]
            adjLists[pos1] = new ListCell(v2, w, adjLists[pos1]);
            // also add a new cell with values (v1,w) to the front of the list adjLists[pos2] - need similar line to above
            adjLists[pos2] = new ListCell(v1, w, adjLists[pos2]);
            return true;  // added successfully
        }
    }

    public String toString() {
        // should return a string containing all of the edges in the graph with their weights
        // e.g. "(A,B,2), (A,C,3), (B,D,4), (B,A,2), (C,A,3), (D,B,4)"
        if (adjLists.length == 0){
            return "Graph is empty";
        }
        StringBuffer sb = new StringBuffer();
        for ( int pos = 0; pos < adjLists.length; pos++ ) {
            ListCell cell = adjLists[pos];
            char vertex = (char) ('A'+pos);

            while ( cell != null ) {
                sb.append("(" + vertex + "," + cell.vertex + "," + cell.weight + ")");
                cell = cell.next;

                if (adjLists[pos].next != null) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }

    public boolean neighbours(char v1, char v2) {
        // should return true if there's an edge from v1 to v2
        // should return false if there's no such edge
        // need to search the linked list ajdLists[v1-'A'] to see if contains a node whose vertex variable is equal to v2
        // code below is supplied just to allow file to compile
        return false;
    }

    public int edgeWeight(char v1, char v2) {
        // should return the weight of the edge from v1 to v2, or a default value (e.g. -1) if there's no such edge
        // again need to search the linked list ajdLists[v1-'A'] but this time if a node whose vertex is v2 is found have to return its weight
        // code below is supplied just to allow file to compile
        return 0;
    }
}



// linked list - each cell contains a vertex name, a weight and a reference to the next item in the list
class ListCell {
    char vertex;
    int weight;
    ListCell next;

    ListCell(char v, int w, ListCell nxt) {
        vertex = v;
        weight = w;
        next = nxt;
    }
}



