package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch implements Paths {
	/*
	 * array stores node/vertices has been marked/linked to another node true - if linked to another node false - not linked to any node
	 */
	private final boolean marked[];
	/* array stores link/path to node */
	private final int markedTo[];
	/* root or source node */
	private final int s;
	/* distance from source */
	private final int distTo[];

	public BreadthFirstSearch(final Graph G, final int s) {
		/* save root/source node instance */
		this.s = s;
		/* initialize markedTo array by size equal to no. of vertices */
		markedTo = new int[G.getV()];
		/* initialize distTo by size equal to no. of vertices */
		distTo = new int[G.getV()];
		/* initialize marked by size equal to no. */
		marked = new boolean[G.getV()];
		/* mark status of all vertices or nodes as false */
		Arrays.fill(marked, false);
		/* set default value for distTo to -1 */
		Arrays.fill(distTo, -1);
		/* set default value for markedTo to -1 */
		Arrays.fill(markedTo, -1);
		/* call BFS */
		bfs(G, s);
	}

	private void bfs(final Graph G, final int src) {
		/* create a queue */
		Queue<Integer> queue = new Queue<Integer>();
		/* add source node to queue */
		queue.enqueue(src);
		/* mark source as true or linked */
		marked[src] = true;
		/* source linked to source */
		markedTo[src] = src;
		/* distance from source - start with zero */
		distTo[src] = 0;
		/* start with source node */
		int currNode = 0;
		while (!queue.isEmpty()) {
			/* pull current node from queue */
			currNode = queue.dequeue();
			/* for all adjacent vertices for current node */
			for (int edge : G.adj(currNode)) {
				/* if not marked or linked */
				if (!marked[edge]) {
					/* add to the queue */
					queue.enqueue(edge);
					/* mark as linked */
					marked[edge] = true;
					/* establish link between current and adjacent node */
					markedTo[edge] = currNode;
					/* distance = distance of source from current node + 1 */
					distTo[edge] = distTo[currNode] + 1;
				}
			}
		}
	}

	@Override
	public boolean hasPathTo(final int v) {
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(final int v) {
		if (!marked[v]) {
			return null;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int parent = v;
		while (parent != s) {
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
