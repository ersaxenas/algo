package alogpart1.mst;

import alogpart1.unionfind.UnionFind1;
import edu.princeton.cs.algs4.MinPQ;

public class KrushkalMST extends MST{

	public KrushkalMST(EdgeWeightedGraph graph) {
		super(graph);
	}

	@Override
	public void buildMst(EdgeWeightedGraph graph) {
		MinPQ<Edge> minPq = new MinPQ<Edge>();
		for(Edge edge: graph.getEdges()) {
			minPq.insert(edge);
		}
		UnionFind1 uf1 = new UnionFind1(graph.getV());
		int v, w;
		while(!minPq.isEmpty() && mst.size() < graph.getV() -1) {
			Edge edge = minPq.delMin();
			v = edge.getV();
			w = edge.getW();
			if(!uf1.isConnected(v,w)){
				uf1.unionElem(v, w);
				mst.enqueue(edge);
			}
		}
	}

}
