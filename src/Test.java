//import java.util.Scanner;

public class Test {

	public Graph graph;
	public ShortestPath shortestPath;
	
	static String start;
	static String end;
	
	public Test() {
		graph=new Graph(7,12);
	}
	
	public static void main(String[] args){
		Test t=new Test();
		t.graph.insertVertex("A");
		t.graph.insertVertex("B");
		t.graph.insertVertex("C");
		t.graph.insertVertex("D");
		t.graph.insertVertex("E");
		t.graph.insertVertex("F");
		t.graph.insertVertex("G");
		t.graph.insertEdge("A", "B", 4);
		t.graph.insertEdge("A", "C", 3);
		t.graph.insertEdge("A", "E", 7);
		t.graph.insertEdge("B", "D", 5);
		t.graph.insertEdge("B", "C", 6);
		t.graph.insertEdge("C", "D", 11);
		t.graph.insertEdge("C", "E", 8);
		t.graph.insertEdge("D", "E", 2);
		t.graph.insertEdge("D", "F", 2);
		t.graph.insertEdge("D", "G", 10);
		t.graph.insertEdge("E", "G", 5);
		t.graph.insertEdge("G", "F", 3);
		
		/*
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter in the start city:");
		start=sc.next();
		System.out.println("please enter in the end city:");
		end=sc.next();
		*/
		
		t.shortestPath=new ShortestPath("A","F",t.graph);
		t.shortestPath.findShortest();
		
	}

}
