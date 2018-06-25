package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDirectedDepthFirstSearch implements Paths{
	private final boolean marked[];
	private final int markedTo[];
	private final int s;
	private final Stack<Integer> stack = new Stack<Integer>();

	public TopologicalSortDirectedDepthFirstSearch(final Graph G, final int s) {
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

	private void dfs(final Graph G, final int src) {
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

	@Override
	public boolean hasPathTo(final int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(final int v) {
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
	public void paths(final Graph G, final int s) {
		throw new UnsupportedOperationException("Operation paths(Graph G, int s) is not supported.");
	}

}
