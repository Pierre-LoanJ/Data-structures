package graphs;

public class CC {
	// Connected Components
	private int[] id;
	private int[] edgeTo;
	private boolean marked[];
	private int count;
	
	public CC(Graph g) {
		marked = new boolean[g.V()];
		id = new int[g.V()];
		
		this.count = 0;
		
		for (int x = 0; x < g.V(); x++) {
			if (!marked[x]) {
				depthFirstSearch(g, x); // why not bfs as well ?
				count++;
			}
		}
	}
	
	private void depthFirstSearch(Graph g, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				depthFirstSearch(g, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean connected(int v, int w) { // are v & w connected
		return id[v] == id[w];
	}
	public int count() { // how many components are in this graph
		return this.count;
	}
	public int id(int v) { // the id of the component v belongs to
		return id[v];
	}
}
