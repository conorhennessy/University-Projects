public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge('A', 'B', 3);
        graph.addEdge('B', 'D', 2);
        graph.addEdge('D', 'C', 7);
        graph.addEdge('C', 'A', 5);
        graph.addEdge('B', 'E', 4);
        System.out.println(graph.toString());
    }
}
