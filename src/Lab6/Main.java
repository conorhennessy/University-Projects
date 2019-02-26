public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge('A', 'B', 3);
        graph.addEdge('B', 'D', 2);
        graph.addEdge('D', 'C', 7);
        graph.addEdge('C', 'A', 5);
        System.out.println(graph.toString());
    }
}
