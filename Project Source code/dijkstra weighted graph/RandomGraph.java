package graph;

import java.util.*;

public class RandomGraph {

	private WeightedGraph graph;
	private Random r;
	Queue<Integer> pq;
	private int weight;
	private Edge e;
	private ArrayList<Edge> visited = new ArrayList<>();
//	HashSet<Integer> visited;

	public RandomGraph(int vertex, int edge) {
//		RandomGraph rgraph = new RandomGraph(vertex, edge);
		graph = new WeightedGraph(edge);
		r = new Random();
		e = new Edge();
		connectRandomVertex(vertex);
		graph.dijkstra(graph, r.nextInt(edge));
	}

	public void connectRandomVertex(int vertex) {
		for (int i = 0; i < vertex; i++) {
			int v1 = r.nextInt(graph.getNumberOfVertex());
			int v2 = r.nextInt(graph.getNumberOfVertex());
			if (v1 == v2 || graph.isConnected(v1, v2)) {
				i--;
			} else {
				weight = r.nextInt(10) + 1;
				graph.addEdge(v1, v2, weight);
			}
		}
	}

	public void dijkstra(RandomGraph rgraph, int src) {
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
			for (Edge v : graph.neighbours(u.getVertex())) {
				if(!visited.contains(v)) {
					int alt = dist[u.getVertex()] + v.getWeight();
					if(alt<0) {
						dist[v.v] = 0;
					}
					else if(alt<dist[v.v]) {
						dist[v.v] = alt;
						prev[v.v] = u.v;
						pq.add(new Edge(v.v,alt));
					}
				}
				
			}
			visited.add(u);
		}
		String c = e.getCharForNumber(src);
		System.out.println(c +" "+ Arrays.toString(dist));
	}

	public int getNumberOfVertex() {
		return graph.getNumberOfVertex();
	}

	public String toString() {
		return graph.toString();
	}

	public static void main(String[] args) {
		Random r = new Random();
		int vertex = 40;
		int edges = 20;	
		RandomGraph rgraph = new RandomGraph(vertex, edges);
		
		System.out.println(rgraph.toString());
//		rgraph.dijkstra(rgraph, r.nextInt(vertex));

	}
}
