package graphs;

import queue.LinkedQueue;
import stack.LinkedStackGeneric;

public class Paths {
	private boolean marked[]; // marked[i] == true si le noeud i a été visité
	private int edgeTo[];     // edgeTo[a] == b : on arrive sur a en venant de b
	private int distTo[];     // distTo[a] == b : b edges entre s et a
	private final int s;
	
	
	public Paths(Graph g, int s) {
		this.s = s;
		depthFirstSearch(g, s); // or bfs call depends on which we want to use
	}
	
	private void depthFirstSearch(Graph g, int v) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				depthFirstSearch(g, w);
				edgeTo[w] = v;
			}
		}
	}
	
	private void breadthFirstSearch(Graph g, int s) {
		// bfs ables to get the shortest path from s to v
		// because it processes the nodes from the same distance to the source at the same time 
		// and only then when they are all done it processes the nodes from the distance n+1
		// no matter the order the nodes from the same distance are processed
		
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		int dist = 0;
		
		q.enqueue(s);
		marked[s] = true;
		distTo[s] = dist;
		
		while(!q.isEmpty()) {
			int v = q.dequeue();
			dist++;
			
			for (int w : g.adj(v)) {
				if (!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = dist;
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		// is there a path from s to v
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		// what is the path from s to v
		if (this.hasPathTo(v)) {
			LinkedStackGeneric<Integer> stack = new LinkedStackGeneric<Integer>();
			Integer previous = null;
			while(previous != this.s) {
				previous = this.edgeTo[v];
				stack.push(previous);
				v = previous;
			}
			stack.push(this.s);
			return stack;
		}
		return null;
	}
	
}
