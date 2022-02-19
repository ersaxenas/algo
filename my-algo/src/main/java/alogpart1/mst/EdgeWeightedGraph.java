package alogpart1.mst;

import java.util.ArrayList;
import java.util.List;

import alogpart1.bag.Bag;
import alogpart1.bag.BagImpl;

public class EdgeWeightedGraph {

	Bag<Edge> vertex[];
	private int V;
	private int E;
	List<Edge> lst = new ArrayList<Edge>();
	
	public EdgeWeightedGraph(int V) {
		this.V = V;
		vertex = new Bag[V];
		for(int cnt=0; cnt<V; cnt++) {
			vertex[cnt] = new BagImpl<Edge>();
		}
	}
	
	public void addEdge(Edge edge) {
		int v = edge.getV();
		int w = edge.getW();
		vertex[v].add(edge);
		vertex[w].add(edge);
		lst.add(edge);
		E++;
	}
	
	public Iterable<Edge> getEdges() {
		return lst;
	}
	
	public Iterable<Edge> getEdges(int v) {
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
