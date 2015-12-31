package alogpart1.graph;

import java.util.Random;


public class App {

	public void testDFS() {
		Graph graph = new Unigraph(7);
		graph.addEdge(0, 5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(6, 4);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(5, 3);
		Paths path = new PathImpl(SearchAlgo.UNI_DFS);
		path.paths(graph, 0);
        System.out.println("0:"+path.pathTo(0));
        System.out.println("1:"+path.pathTo(1));
        System.out.println("2:"+path.pathTo(2));
        System.out.println("3:"+path.pathTo(3));
        System.out.println("4:"+path.pathTo(4));
        System.out.println("5:"+path.pathTo(5));
        System.out.println("6:"+path.pathTo(6));
        
	}
	
	public void testBFS() {
		Graph graph = new Unigraph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 3);
		graph.addEdge(3, 5);
		Paths path = new PathImpl(SearchAlgo.UNI_BFS);
		path.paths(graph, 0);
        System.out.println("0:"+path.pathTo(0));
        System.out.println("1:"+path.pathTo(1));
        System.out.println("2:"+path.pathTo(2));
        System.out.println("3:"+path.pathTo(3));
        System.out.println("4:"+path.pathTo(4));
        System.out.println("5:"+path.pathTo(5));
        
	}
	
	public void testcc() {
		Graph graph = new Unigraph(13);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(4, 3);
		graph.addEdge(3, 5);
		graph.addEdge(7, 8);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(9, 12);
		graph.addEdge(11, 12);
		GraphConnectedComp cc = new GraphConnectedComp(graph);
        System.out.println("total cc"+cc.getComp());
        Random random = new Random();
        int a,b;
        for(int cnt =0; cnt<20; cnt++) {
        	a = random.nextInt(13);
        	b = random.nextInt(13);
        	System.out.println(a+"-"+b+":"+cc.connected(a, b));
        }
	}
	
	public void testTopologicalSort() {
		Graph graph = new Digraph(7);
		graph.addEdge(0, 5);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(3, 6);
		graph.addEdge(3, 5);
		graph.addEdge(3, 4);
		graph.addEdge(5, 2);
		graph.addEdge(6, 4);
		graph.addEdge(6, 0);
		graph.addEdge(3, 2);
		graph.addEdge(1, 4);
		TopologicalSortDirectedDepthFirstSearch tps = new TopologicalSortDirectedDepthFirstSearch(graph, 0);
        System.out.println(tps.reversePost());
	}
	
	public static void main(String args[]) {
		App obj = new App();
		obj.testTopologicalSort();
	}
	
}
