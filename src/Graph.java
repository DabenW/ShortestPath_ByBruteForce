

public class Graph {

	public Vertex[] head;//指向顶电表的应用
	public EdgeNode[] edgeNodes;
	private int firstFreeVertex=0;
	private int firstFreeEdge=0;
	
	private int vertexNum;
	private int edgeNum;
	
	
	public Graph(int v,int e) {
		
		this.vertexNum=v;
		this.edgeNum=e;
		head=new Vertex[v];
		edgeNodes=new EdgeNode[e];
		
	}
	
	public int getVertexNum() {
		return vertexNum;
	}
	
	public int getEdgeNum() {
		return edgeNum;
	}
	
	public void insertVertex(String name) {
		head[firstFreeVertex]=new Vertex(name);
		firstFreeVertex++;
	}
	
	public void insertEdge(String fromVertex,String toVertex,int weight) {
		int from=0,to=0;
		//it's like sorting the vertex, use the order of the vertex in array as from and to
		//get the edge's start and end position
		for(int i=0;i<firstFreeVertex;i++){
			if(head[i].getName()==fromVertex){
				from=i;
			}
		}
		for(int i=0;i<firstFreeVertex;i++){
			if(head[i].getName()==toVertex){
				to=i;
			}
		}
		//初始化node1
		EdgeNode node1=new EdgeNode(weight);
		node1.setIndexVertex(to);//example:A-B,"-B"is this node1,B is to
		if(head[from].getEdgeNode()==null) {//add B to A链表的末尾
			head[from].setEdgeNode(node1);
		}else {
			addNextEdge(head[from].getEdgeNode(),node1);
		}
		
		edgeNodes[firstFreeEdge]=node1;
		firstFreeEdge++;
		
		//初始化node2
		EdgeNode node2=new EdgeNode(weight);
		node2.setIndexVertex(from);
		if(head[to].getEdgeNode()==null) {
			head[to].setEdgeNode(node2);
		}else {
			addNextEdge(head[to].getEdgeNode(),node2);
		}
		
		
	}
	
	private void addNextEdge(EdgeNode list,EdgeNode nextNode) {
		EdgeNode en=list;//邻接链表里的first Node
		while(en.getNextEdge()!=null) {//if next is not null,then find the next,to add at the end
			en=en.getNextEdge();
		}
		en.setNextEdge(nextNode);//add the new one too the end of list
	}
	
	public Vertex[] getVertexList() {
		return this.head;
	}
	
	public Vertex changePositionToVertex(int Pos) {
		return this.head[Pos];
	}
}
