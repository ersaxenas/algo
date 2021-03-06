package alogpart1.graph;

import alogpart1.bag.Bag;
import alogpart1.bag.BagImpl;

public class Digraph implements Graph{
     private final int V;
     private int E = 0;
	 private Bag<Integer> adj[];
	 
	 public Digraph(int noOfVertex) {
		 V=noOfVertex;
		 adj = new Bag[noOfVertex];
		 for(int cnt=0; cnt<noOfVertex; cnt++) {
			 adj[cnt] = new BagImpl<Integer>();
		 }
	 }
	 
	 public void addEdge(int v, int w) {
		 adj[v].add(w);
		 E++;
	 }
	 
	 public int getV() {
		 return V;
	 }
	 
	 public int getE() {
		 return E;
	 }
	 
	 public Iterable<Integer> adj(int v) {
		 return adj[v];
	 }
	 
	
}
