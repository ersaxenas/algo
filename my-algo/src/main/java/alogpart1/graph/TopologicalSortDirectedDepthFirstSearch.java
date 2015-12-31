package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDirectedDepthFirstSearch implements Paths{
	private boolean marked[];
	private int markedTo[];
	private int s;
	private Stack<Integer> stack = new Stack<Integer>();
	
	public TopologicalSortDirectedDepthFirstSearch(Graph G, int s) {
		this.s = s;
		markedTo = new int[G.getV()];
		marked = new boolean[G.getV()];
		Arrays.fill(marked, false);
		for(int cnt=0; cnt<G.getV(); cnt++) {
			if(!marked[cnt]) {
				dfs(G,cnt);
			}
		}
	}
	
	private void dfs(Graph G, int src) {
		marked[src] = true;
		for(int edge: G.adj(src)) {
			if(!marked[edge]) {
				dfs(G,edge);
				markedTo[edge] = src;
			}
		}
		stack.push(src);
	}
	
	public Iterable<Integer> reversePost() {
		return stack;
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if(!marked[v]) {
			return null;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int parent = v;
		while(parent != s) {
			stack.push(parent);
			parent = markedTo[parent];
		}
		stack.push(s);
		return stack;
	}

	@Override
	public void paths(Graph G, int s) {
		throw new UnsupportedOperationException("Operation paths(Graph G, int s) is not supported.");
	}

}
