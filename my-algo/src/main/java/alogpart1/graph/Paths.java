package alogpart1.graph;

public interface Paths {

	void paths(Graph G, int s);
	boolean hasPathTo(int v); 
	Iterable<Integer> pathTo(int v);
}
