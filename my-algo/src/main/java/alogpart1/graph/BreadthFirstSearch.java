package alogpart1.graph;

import java.util.Arrays;
import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch implements Paths{
	private boolean marked[];
	private int markedTo[];
	private int s;
	private int distTo[];
	
	public BreadthFirstSearch(Graph G, int s) {
		this.s = s;
		markedTo = new int[G.getV()];
		distTo = new int[G.getV()];
		marked = new boolean[G.getV()];
		Arrays.fill(marked, false);
		Arrays.fill(distTo, -1);
		Arrays.fill(markedTo, -1);
		bfs(G,s);
	}
	
	private void bfs(Graph G, int src) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(src);
		marked[src] = true;
		markedTo[src] = src;
		distTo[src]= 0;
		int currNode = 0;
		while(!queue.isEmpty()) {
			currNode = queue.dequeue();
			for(int edge : G.adj(currNode)) {
				if(!marked[edge]) {
					queue.enqueue(edge);
					marked[edge] = true;
					markedTo[edge] = currNode;
					distTo[edge] = distTo[currNode]+1;
				}
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
