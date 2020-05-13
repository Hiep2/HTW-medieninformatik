package graph;

import java.util.*;


public class WeightedGraph implements Graph {
	private LinkedList<Edge> adjList[];
	private Edge edge;
	private int v;
//	private int[] dist;
//	private HashSet<Integer> visited;
//	private PriorityQueue<Edge> pq;
	private Random r;
	private ArrayList<Edge> visited = new ArrayList<>();

	public WeightedGraph(int v) {
		adjList = new LinkedList[v];
		edge = new Edge();
		r = new Random();
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
//		dijkstra(adjList, r.nextInt(v));
	}

	public void addEdge(int s, int v, int w) {
		adjList[s].addFirst(new Edge(v, w));
	}

	public boolean isConnected(int s, int v) {
		for (Edge e : adjList[s]) {
			if (e.v == v) {
				return true;
			}
		}
		return false;
	}

	public int getNumberOfVertex() {
		return adjList.length;
	}
	
	public int getv() {
		return v;
	}
	
	public LinkedList<Edge>[] getGraph(){
		return adjList;
	}
	
	public LinkedList<Edge> neighbours(int vertex) {
        return adjList[vertex];
    }
	
	public void dijkstra(Graph g, int src) {
		int[] dist = new int[getNumberOfVertex()];
		int[] prev = new int[getNumberOfVertex()];
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < getNumberOfVertex(); i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
				prev[i] = -1;
			}
			pq.add(new Edge(i, dist[i]));
			dist[src] = 0;
		}
		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			for (Edge v : neighbours(u.v)) {
				int alt = dist[u.v] + v.w;
				if(alt<0) {
					dist[v.v] = 0;
				}
				else if(alt<dist[v.v]) {
					dist[v.v] = alt;
					prev[v.v] = u.v;
					pq.add(new Edge(v.v,alt));
				}
					
			}
			visited.add(u);
		}
		String c = edge.getCharForNumber(src);
		System.out.println(c +" "+ Arrays.toString(dist) +"\n");
	}

	private void printDijkstra(int src, int[] dist, int[] prev) {
		int n = 0;
		for (int i = 0; i < n; i++) {
			if (i != src) {
				System.out.print("\n" + src + " -> ");
				System.out.print(i + " \t\t ");
				System.out.print(dist[i] + "\t\t");
				printPath(i, prev);
			}
		}
	}

	private static void printPath(int currentVertex, int[] prev) {

		if (currentVertex == -1) {
			return;
		}
		printPath(prev[currentVertex], prev);
		System.out.print(currentVertex + " ");
	}
	

	@Override
	public String toString() {
		String result = "";

		for (int i = 0; i < adjList.length; i++) {
			String c = edge.getCharForNumber(i);
			result += "[" + c + "]" + "-->" + adjList[i] + "\n";
		
		}
		return result;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int vertex = 6;
		WeightedGraph graph = new WeightedGraph(vertex);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 7);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 0, 4);
		graph.addEdge(4, 1, 4);
		graph.addEdge(4, 5, 6);
		graph.addEdge(5, 3, 8);
		System.out.println(graph);
		System.out.println(graph.neighbours(1));
		int s = 1;
		int v = 3;
		if (graph.isConnected(s, v)) {
			System.out.println(s + " is connected to "+v);
		}
		graph.dijkstra(graph,5);
//		r.nextInt(vertex)
	}

	

}
