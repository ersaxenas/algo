package alogpart1.graph;

import java.util.Arrays;

public class GraphConnectedComp {

	private boolean marked[];
	private int comp[];
	private int count = 0;

	public GraphConnectedComp(Graph G) {
		marked = new boolean[G.getV()];
		comp = new int[G.getV()];
		Arrays.fill(marked, false);
		Arrays.fill(comp, -1);
		markeComp(G);
	}
	
	private void markeComp(Graph G) {
		for(int cnt =0; cnt< marked.length; cnt++) {
			if(!marked[cnt]) {
				dfs(G,cnt);
				count++;
			}
		}
	}

	private void dfs(Graph G, int src) {
		marked[src] = true;
		comp[src] = count;
		for(int edge : G.adj(src)) {
			if(!marked[edge]) {
					dfs(G,edge);
			}
		}
	}
	
	public boolean connected(int v , int w) {
		return comp[v] == comp[w];
	}
	
	public int getComp() {
		return count;
	}
	
	public int getCompId(int v) {
		return comp[v];
	}

}
