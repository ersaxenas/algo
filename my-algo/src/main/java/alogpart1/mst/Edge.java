package alogpart1.mst;

public class Edge implements Comparable<Edge>{
	
	private int v, w, wt;
	
	public Edge(int v, int w, int wt) {
		this.v =v;
		this.w=w;
		this.wt=wt;
	}

	@Override
	public int compareTo(Edge other) {
		if(this.wt < other.wt) {
           return -1;			
		} else if(this.wt > other.wt) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int getV() {
		return v;
	}

	public int getW() {
		return w;
	}


	public int getWt() {
		return wt;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", wt=" + wt + "]";
	}
}
