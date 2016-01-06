package alogpart1.mst;

import alogpart1.graph.Digraph;
import alogpart1.graph.Graph;
import alogpart1.graph.TopologicalSortDirectedDepthFirstSearch;

public class App {

	public void testKrushkalMst() {
		EdgeWeightedGraph graph = new EdgeWeightedGraph(7);
		graph.addEdge(new Edge(0,5,1));
		graph.addEdge(new Edge(0,2,4));
		graph.addEdge(new Edge(0,1,3));
		graph.addEdge(new Edge(3,6,7));
		graph.addEdge(new Edge(3,5,9));
		graph.addEdge(new Edge(3,4,6));
		graph.addEdge(new Edge(5,2,2));
		graph.addEdge(new Edge(6,4,5));
		graph.addEdge(new Edge(6,0,8));
		graph.addEdge(new Edge(3,2,11));
		graph.addEdge(new Edge(1,4,34));
		MST mst = new KrushkalMST(graph);
        System.out.println(mst.getEdges());
	}
	
	public void testdijkstraSP() {
		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
		graph.addEdge(new DirectedEdge(0,1,5));
		graph.addEdge(new DirectedEdge(0,4,9));
		graph.addEdge(new DirectedEdge(0,7,8));
		graph.addEdge(new DirectedEdge(1,2,12));
		graph.addEdge(new DirectedEdge(1,3,15));
		graph.addEdge(new DirectedEdge(1,7,4));
		graph.addEdge(new DirectedEdge(2,3,3));
		graph.addEdge(new DirectedEdge(2,6,11));
		graph.addEdge(new DirectedEdge(3,6,9));
		graph.addEdge(new DirectedEdge(4,5,4));
		graph.addEdge(new DirectedEdge(4,6,20));
		graph.addEdge(new DirectedEdge(4,7,5));
		graph.addEdge(new DirectedEdge(5,2,1));
		graph.addEdge(new DirectedEdge(5,6,13));
		graph.addEdge(new DirectedEdge(7,2,7));
		graph.addEdge(new DirectedEdge(7,5,6));
		
		
		DijkstraShortestPath mst = new DijkstraShortestPath(graph,0);
        System.out.println(mst.pathTo(2));
	}
	
	public static void main(String[] args) {
		App obj = new App();
            obj.testdijkstraSP();
	}

}
