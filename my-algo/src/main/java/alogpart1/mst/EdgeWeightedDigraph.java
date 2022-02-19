package alogpart1.mst;

import java.util.ArrayList;
import java.util.List;

import alogpart1.bag.Bag;
import alogpart1.bag.BagImpl;

public class EdgeWeightedDigraph {

	Bag<DirectedEdge> vertex[];
	private int V;
	private int E;
	List<DirectedEdge> lst = new ArrayList<DirectedEdge>();
	
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		vertex = new Bag[V];
		for(int cnt=0; cnt<V; cnt++) {
			vertex[cnt] = new BagImpl<DirectedEdge>();
		}
	}
	
	public void addEdge(DirectedEdge edge) {
		int v = edge.getV();
		int w = edge.getW();
		vertex[v].add(edge);
		lst.add(edge);
		E++;
	}
	
	public Iterable<DirectedEdge> getEdges() {
		return lst;
	}
	
	public Iterable<DirectedEdge> getEdges(int v) {
		 return vertex[v];
	 }

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}
}
