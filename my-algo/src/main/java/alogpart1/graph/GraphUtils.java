package alogpart1.graph;

public class GraphUtils {

	public static int degree(Graph G, int vtx) {
		int deg = 0;
		for(Integer cnt : G.adj(vtx)) {
			deg++;
		}
		return deg;
	}
	
	public static int maxDegree(Graph G) {
		int max = 0;
		for(int cnt =0; cnt<G.getV(); cnt++) {
			int deg = degree(G, cnt);
			if(deg > max) {
				max = deg;
			}
		}
		return max;
	}
	
	public static double avgDegree(Graph G) {
		return ((G.getE() * 2)/G.getV());
	}
	
	public static int noOfSelfLoop(Graph G) {
		int selfLoop = 0;
		for(int cnt=0; cnt<G.getV();cnt++) {
			for(int v : G.adj(cnt)) {
				if(v == cnt) {
					selfLoop++;
				}
			}
		}
		return selfLoop/2;
	}
	
	
}
