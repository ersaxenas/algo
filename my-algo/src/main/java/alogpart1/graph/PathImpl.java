package alogpart1.graph;

public class PathImpl implements Paths {
	private Paths searchAlgo = null;
	private SearchAlgo type = null;
	
	public PathImpl(SearchAlgo type) {
		this.type = type;
	}

	@Override
	public void paths(Graph G, int s) {
		if(type == SearchAlgo.UNI_DFS) {
			searchAlgo = new DepthFirstSearch(G, s);
		}
		else if(type == SearchAlgo.UNI_BFS) {
			searchAlgo = new BreadthFirstSearch(G, s);
		}
		else if(type == SearchAlgo.DIR_DFS) {
			searchAlgo = new DirectedDepthFirstSearch(G, s);
		}
		else if(type == SearchAlgo.DIR_BFS) {
			searchAlgo = new DirectedBreadthFirstSearch(G, s);
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return searchAlgo.hasPathTo(v);
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		return searchAlgo.pathTo(v);
	}

}
