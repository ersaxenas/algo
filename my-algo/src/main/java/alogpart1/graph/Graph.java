package alogpart1.graph;


public interface Graph {
	 
	 public void addEdge(int v, int w);
	 
	 public int getV(); 
	 
	 public int getE(); 
	 
	 public Iterable<Integer> adj(int v); 
	 
	
}
