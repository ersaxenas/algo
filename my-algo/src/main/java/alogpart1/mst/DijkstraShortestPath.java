package alogpart1.mst;

import java.util.Arrays;
import java.util.Stack;

import edu.princeton.cs.algs4.IndexMinPQ;

public class DijkstraShortestPath {
	
	private DirectedEdge edgeTo[];
	private double distTo[];
	private IndexMinPQ<Double> minPQ;
	
	public DijkstraShortestPath(EdgeWeightedDigraph graph, int src) {
		edgeTo = new DirectedEdge[graph.getV()];
		distTo = new double[graph.getV()];
		minPQ = new IndexMinPQ<Double>(graph.getV());
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[src] = 0;
        edgeTo[src] = null;
        minPQ.insert(src, 0.0);
        while(!minPQ.isEmpty()) {
        	int v = minPQ.delMin();
        	for(DirectedEdge edge : graph.getEdges(v)) {
        		relax(edge);
        	}
        }
	}

	private void relax(DirectedEdge edge) {
		int v = edge.getFrom();
		int w = edge.getTo();
		int wt = edge.getWt();
		if(distTo[w] > distTo[v]+wt) {
			distTo[w] = distTo[v]+wt;
			edgeTo[w] = edge;
			if(minPQ.contains(w)) {
				minPQ.decreaseKey(w, distTo[w]);
			}
			else {
				minPQ.insert(w, distTo[w]);
			}
		}
	}
	
	public double distanceTo(int v) {
		return distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
		for(DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.getFrom()]) {
			stack.push(edge);
		}
		return stack;
	}
}
