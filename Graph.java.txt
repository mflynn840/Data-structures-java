import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph{

    //adjList[i] contains all out neighbors of vertex i;
    LinkedList[] adjList;
    int n;
    int m;
    private boolean[] visited;

    public Graph(int n){

        this.n = n;

        this.adjList = new LinkedList[n];

        for(int i = 0; i<n; i++){
            this.adjList[i] = new LinkedList();
        }

    }

    public int shortestPathFromIThroughJToK

    public void addEdge(int fromVertex, int toVertex){
        

        if (inBounds(fromVertex) && inBounds(toVertex)){
            LinkedList.append(this.adjList[fromVertex], toVertex);
        }else{
            System.out.println("ERROR: index out of bounds");
        }
    }

    public boolean inBounds(int v){
        return v >= 0 && v<this.n;
    }


    public double[] Dijkstras(int source){
        double[] D = new double[this.n];


        for(int i = 0; i<this.n; i++){
            if(i!= source){
                D[i] = Double.POSITIVE_INFINITY;
            }
        }

        D[source] = 0;

        class KeyValue {
            double key;
            int value;

            public KeyValue(double key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        PriorityQueue<KeyValue> Q = new PriorityQueue<>((a,b) -> Double.compare(a.key, b.key));
        Q.add(new KeyValue(D[source], source));

        while (!Q.isEmpty()){
            int curr = Q.poll().value;

            Iterator<Integer> iterator = this.adjList[curr].iterator();
            while(iterator.hasNext()){
                int neighbor = iterator.next();
                if(D[neighbor] > D[curr] + 1){
                    D[neighbor] = D[curr] + 1;
                    Q.add(new KeyValue(D[neighbor], neighbor));
                }

            }

        }
        return D;
    }

    public double[] bellmanFord(int source){

        double[] D = new double[this.n];
        for(int i = 0; i<this.n; i++){
            if(i!= source){
                D[i] = Double.POSITIVE_INFINITY;
            }
        }

        for(int i = 0; i<n-1; i++){
            for(int vertex = 0; vertex < this.n; vertex++){
                Iterator<Integer> iterator = this.adjList[vertex].iterator();
                while(iterator.hasNext()){
                    int neighbor = iterator.next();
                    if(D[vertex] != Double.POSITIVE_INFINITY){
                        if(D[neighbor] > D[vertex]+1){
                            D[neighbor] = D[vertex]+1;
                        }
                    }
                }
            }
        }
        return D;
    }

    public void DFS(){
        this.visited = new boolean[this.n];
        for(int i =0; i<this.n; i++){
            this.visited[i] = false;
        }

        for(int i = 0; i<this.n; i++){
            if(!this.visited[i]){
                explore(i);
            }
        }
    }

    public void explore(int v){
        this.visited[v] = true;

        Iterator<Integer> neighbors = this.adjList[v].iterator();

        while(neighbors.hasNext()){
            int neighbor = neighbors.next();
            if(!this.visited[neighbor]){
                this.explore(neighbor);
            }
        }

    }

    //Floyd-Warshall Algorithm pariwise shortest paths in a graph in O(V^3):
    public static double[][] FloydWarshall(Graph G){


        //we want to compute this for every pair of verticies i and j.  
        //Its the length of the shortest weighted path in the graph between vertex i and vertex j
        double[][] shortestPath = new double[G.n][G.n];


        //Initilization 1: every path gets infinity to start, path from vertex to itself gets 0
        for(int i = 0; i<G.n; i++){
            for(int j = 0; j<G.n; j++){

                if(i == j){
                    shortestPath[i][j] = 0;
                }

                //infinty
                shortestPath[i][j] = Double.MAX_VALUE;
            }
        }

        //Initialization2: //adj list iteration: for each edge in the graph (i, j) set the path to that edge weight
        for(int i = 0; i<G.n; i++){

            Iterator<Integer> outNeighbors = G.adjList[i].iterator();
           // dist[i][j] = to the weight of the edge between vertices i and j if there is an edge;
            while(outNeighbors.hasNext()){
               int next = outNeighbors.next();
                shortestPath[i][next] = next;
            }
        }

        
        //for each alternate path k
        for(int k= 0; k<G.n; k++){


            //for each possible edge (i, j)s weight
            for(int i = 0; i<G.n; i++){
                Iterator<Integer> outNeighbors = G.adjList[i].iterator();
                while(outNeighbors.hasNext()){
                    int j = outNeighbors.next();
                    int alternatePathLength = shortestPath[i][k] + G.getEdgeWeight(k, j);


                    //shortestPath[i][j] = min{shortestPath[i][k] + w(k, j), shortestPath[i][j]}
                    if(alternatePathLength < shortestPath[i][j]){
                        shortestPath[i][j] = alternatePathLength;
                    }

                }
            }
        }

        return shortestPath;
    }
    


/* 
    Prim's Algorithm: Constructs a minimum spanning tree for a connected, undirected graph with weighted edges.

    
    Kruskal's Algorithm: Constructs a minimum spanning tree for a connected, undirected graph with weighted edges using a greedy approach.
    
    Topological Sorting: Arranges the nodes of a directed acyclic graph (DAG) in a linear order such that for every directed edge (u, v), node u comes before node v.
    
    Connected Components: Identifies the connected components in an undirected graph.
    
    Strongly Connected Components (SCC): Identifies strongly connected components in a directed graph using algorithms like Kosaraju's algorithm or Tarjan's algorithm.
    
    Max Flow - Min Cut: Solves network flow problems by finding the maximum flow in a flow network.
    
    Ford-Fulkerson Algorithm: A general algorithm for solving the maximum flow problem.
    
    Bipartite Matching (Hopcroft-Karp Algorithm): Finds the maximum cardinality matching in a bipartite graph.
    
    Minimum Cut: Finds the smallest cut in a graph, separating two disjoint sets of nodes.
    
    Eulerian Circuit: Determines whether a graph has an Eulerian circuit (a circuit that traverses each edge exactly once).
    
    Hamiltonian Cycle: Determines whether a graph has a Hamiltonian cycle (a cycle that visits each node exactly once).
    
    PageRank Algorithm: Measures the importance of nodes in a directed graph, often used in web link analysis.
    
    A Search Algorithm:* An informed search algorithm used for pathfinding and graph traversal, especially in grid-based maps.
    
    Graph Isomorphism: Determines whether two graphs are isomorphic, i.e., if they have a one-to-one correspondence of their nodes.
    
    Randomized Algorithms for Graphs: Includes algorithms like random walks, Monte Carlo methods, and Las Vegas algorithms applied to graph problems.*/

/* 
    Basics of Graph Theory:
        depth-first search (DFS)
        breadth-first search (BFS)

    Shortest Path Algorithms: 
        Study Dijkstra's algorithm, 
        Bellman-Ford algorithm
        Floyd-Warshall algorithm.


    Minimum Spanning Trees:    
        Explore Prim's and Kruskal's algorithms.


    Flow Algorithms: Understand 
    
        max-flow/min-cut algorithms 
                (Ford-Fulkerson, Edmonds-Karp).


    Connectivity and Components:
        Connected Components: Learn about algorithms to find connected components in an undirected graph.
        Strongly Connected Components: Understand algorithms for directed graphs.


    Advanced Graph Theory:
        Graph Isomorphism: Study the problem of determining when two graphs are isomorphic.
        Graph Coloring: Explore problems related to coloring graphs and related theorems (Four-Color Theorem).
        Graph Decompositions: Learn about tree-width, path-width, and related concepts.


        Paths and Cycles:
        Eulerian and Hamiltonian Paths and Cycles: Understand conditions for existence and algorithms for finding these paths.
        Network Flows:
        Max Flow - Min Cut: Explore more advanced topics in network flows and algorithms beyond basic Ford-Fulkerson.


     Random Graphs:
    Erdős–Rényi Model: Study random graphs and their properties.


    Graph Spectra:
        Spectral Graph Theory: Explore eigenvalues and eigenvectors of graph adjacency and Laplacian matrices.


    Algebraic Graph Theory:
        Group Actions on Graphs: Understand how groups act on graphs and related concepts.
        Graph Homomorphisms: Study the theory of graph homomorphisms.

    Topological Graph Theory:
        Graph Embeddings: Explore the theory of embedding graphs in surfaces.
        Planar Graphs: Study properties and algorithms related to planar graphs.


    Dynamic Graphs:
    Dynamic Connectivity: Explore problems related to maintaining connectivity in a dynamic setting.
    Applications of Graph Theory:
    Social Network Analysis: Apply graph theory to analyze social networks.
    Circuit Design and Layout: Explore applications in electrical engineering.
    Read Research Papers:
    Stay updated with current research in graph theory by reading papers published in relevant journals and conferences.
    Programming Skills:
    Develop programming skills to implement and experiment with graph algorithms.
    Attend Conferences and Workshops:
    Attend conferences and workshops related to graph theory to interact with experts and stay informed about the latest developments.
*/    
    /*public boolean inCycle(int v){
        
        for(int i = 0; i<this.n; i++){
            this.visited[i] = false;
        }

        this.explore(v);



    }*/

    public static boolean isDAG(Graph g, ){

    }

    public void findSCCs(){

    }

    public void topSort(){

    }

    public void BFS(){

    }
}



class LinkedList implements Iterable<Integer>{
    
    Node tail;
    int length;

    static class Node{
        int value;
        Node previous;
        Node(int value){this.value = value;}
        Node(){};
    }

    private class LinkedListIterator implements Iterator<Integer>{

        private Node current = tail;

        public boolean hasNext() {
            return current != null;
        }


        public Integer next() {
            if(hasNext()){
                int value = current.value;
                current = current.previous;
                return value;
            }
            throw new java.util.NoSuchElementException();
        }
        
    }

    static LinkedList append(LinkedList x, int value){


        Node newTail = new Node(value);
        newTail.previous = x.tail;
        x.tail = newTail;
        x.length++;
        return x;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    public LinkedList(){
        this.tail = new Node();
        this.length = 0;
    }

    //insertion is done at the end of the list
}

