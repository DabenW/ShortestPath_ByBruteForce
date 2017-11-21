
public class Vertex {

	private String verName;
	protected EdgeNode edge;
	
	public Vertex(String name) {
		this.verName=name;
		edge=null;
	}
	
	public String getName(){
		return verName;
	}
	
	public void setEdgeNode(EdgeNode edge) {
		this.edge=edge;
	}
	
	public EdgeNode getEdgeNode() {
		return edge;
	}

	
}
