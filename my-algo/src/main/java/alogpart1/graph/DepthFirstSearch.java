package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

public class DepthFirstSearch implements Paths{
	private boolean marked[];
	private int markedTo[];
	private int s;
	
	public DepthFirstSearch(Graph G, int s) {
		this.s = s;
		markedTo = new int[G.getV()];
		marked = new boolean[G.getV()];
		Arrays.fill(marked, false);
		dfs(G,s);
	}
	
	private void dfs(Graph G, int src) {
		marked[src] = true;
		for(int edge: G.adj(src)) {
			if(!marked[edge]) {
				dfs(G,edge);
				markedTo[edge] = src;
			}
		}
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
