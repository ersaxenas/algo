package alogpart1.graph;

import alogpart1.bag.Bag;
import alogpart1.bag.BagImpl;

public interface Graph {
	 
	 public void addEdge(int v, int w);
	 
	 public int getV(); 
	 
	 public int getE(); 
	 
	 public Iterable<Integer> adj(int v); 
	 
	
}
