package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

public class DepthFirstSearch implements Paths{
	/* structure
	 * node    | true/false| link between node s and v
	 * vertex  |  marked[] | markedTo v
	 *   0     |     T     |    - (self)
	 *   1     |     T     |    0
	 *   2     |     T     |    0
	 *   3     |     T     |    5
	 *   4     |     T     |    6
	 *   5     |     T     |    4
	 *   6     |     T     |    0
	 *   7     |     T     |    -
	 *   8     |     T     |    -
	 *   9     |     T     |    -
	 *   10    |     T     |    -
	 *   11    |     T     |    -
	 *   12    |     T     |    -
	 */
	/*array stores node/vertices has been marked/linked to another node
	 * true - if linked to another node
	 * false - not linked to any node
	 * */
	private boolean marked[];
	/*array stores link/path to node*/
	private int markedTo[];
	/*start/source of graph node/ sort of root*/
	private int s;
	
	public DepthFirstSearch(Graph G, int s) {
		/*save first node*/
		this.s = s;
		/*initialize marked to or path to array with no, of vertices in the graph */
		markedTo = new int[G.getV()];
		/*initialize marked/visited array with no. of vertices*/
		marked = new boolean[G.getV()];
		/*fill marked/visited array with default value false*/
		Arrays.fill(marked, false);
		/*start depth first search*/
		dfs(G,s);
	}
	
	private void dfs(Graph G, int src) {
		/*mark current node as visited*/
		marked[src] = true;
		/*for each adjacent node if not visited call dfs */
		for(int edge: G.adj(src)) {
			/* recursion : recursive case*/
			/*if not visited call dfs*/
			if(!marked[edge]) {
				dfs(G,edge);
				/*establish link between */
				markedTo[edge] = src;
			}
			/*recursion: base case : if visited just return of do nothing*/
		}
	}
	/**
	 * Path from s to v exists
	 * If boolean flag is true then path from s to v exists
	 * @return True if path from source to v exists else false.
	 * */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	/**
	 * Path from source to V. 
	 * @return An Iterable of nodes of path from s to v or null if no such path exists 
	 */
	public Iterable<Integer> pathTo(int v) {
		if(!marked[v]) {
			return null;
		}
		Stack<Integer> stack = new Stack<Integer>();
		/*start from v node*/
		int parent = v;
		/*if reached to parent node stop else add to stack*/
		while(parent != s) {
			stack.push(parent);
			/*move to next node*/
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
