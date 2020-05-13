package graph;

public interface Graph {
	public void addEdge(int s, int v, int w);

	public boolean isConnected(int s, int v);

	public int getNumberOfVertex();

	public String toString();
}
