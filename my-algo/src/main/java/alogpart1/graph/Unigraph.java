package alogpart1.graph;

import alogpart1.bag.Bag;
import alogpart1.bag.BagImpl;

public class Unigraph implements Graph{
	/*number of vertices or nodes*/
     private final int V;
     /*number of edges*/
     private int E = 0;
     /*an array of bag or list of nodes. 
      * for each node list/bag will have connected nodes 
      * [0] -> List[5,3,10]
      * [1] -> List[4]
      * [2] -> []
      * 
      * here node/vertex 0 has path to node 5,3,10 
      * node 1 has path to 4
      * and node 2 doesn't have any path
      * */
	 private Bag<Integer> adj[];
	 
	 public Unigraph(int noOfVertex) {
		 /*initialize no. of vertex/nodes*/
		 V=noOfVertex;
		 /*Initialize bag or list of connected nodes*/
		 adj = new Bag[noOfVertex];
		 /*initialize each element of array*/
		 for(int cnt=0; cnt<noOfVertex; cnt++) {
			 adj[cnt] = new BagImpl<Integer>();
		 }
	 }
	 
	 /**
	  * establish link between two nodes
	  */
	 public void addEdge(int v, int w) {
		 adj[v].add(w);
		 adj[w].add(v);
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
