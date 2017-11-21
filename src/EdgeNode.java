
public class EdgeNode {

	private int indexVertex;
	private int weight;
	private EdgeNode nextEdge;
	
	public EdgeNode(int weight) {
		this.weight=weight;
		this.nextEdge=null;
	}
	
	public int getIndexVertex() {
		return this.indexVertex;
	}
	
	public void setIndexVertex(int index) {
		this.indexVertex=index;
	}
	
	public EdgeNode getNextEdge() {
		return nextEdge;
	}
	public void setNextEdge(EdgeNode next) {
		this.nextEdge=next;
	}
	
	public int getWeight(){
		return weight;
	}
}
