package alogpart1.mst;

import edu.princeton.cs.algs4.Queue;

public abstract class MST {
 
	protected Queue<Edge> mst = new Queue<Edge>();
	
	public MST(EdgeWeightedGraph graph) {
		buildMst(graph);
	}
	
	public abstract void buildMst(EdgeWeightedGraph graph);
	
	public Iterable<Edge> getEdges() {
		return mst;
	}
	
}
