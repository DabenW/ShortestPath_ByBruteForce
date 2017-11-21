import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ShortestPath {
	private String startVex;
	private String endVex;
	private Graph graph;

	public static Stack<Vertex> stack=new Stack<Vertex>();
	
	public static ArrayList<Object[]> sers=new ArrayList<Object[]>();
	public static ArrayList<Integer> length=new ArrayList<Integer>();
	
	public ShortestPath(String start,String end,Graph graph) {
		startVex=start;
		endVex=end;
		this.graph=graph;
	}
	
	//find the shorest path in all pathes
	public void findShortest(){
		int min=32576;
		
		Vertex startNode=findVertexByName(startVex);
		Vertex endNode=findVertexByName(endVex);
		
		getPaths(startNode,null,startNode,endNode);
		
		//compare to get the shortest
		for(int i=0;i<length.size();i++) {
			if(length.get(i)<min) {
				min=length.get(i);
			}
		}
		System.out.println("The shortest road length is:"+min);
	}
	
	//define if the node is in stack
	public static boolean isNodeInStack(Vertex node) {
		Iterator<Vertex> it=stack.iterator();
		while(it.hasNext()) {
			Vertex node1=(Vertex)it.next();
			if(node==node1)
				return true;
			
		}
		return false;
	}
	
	//save path
    public  void SavePath()  
    {  
    	EdgeNode currentEdge;
    	int sumLength=0;
        Object[] o = stack.toArray();  
        for (int i = 0; i < o.length; i++) {
            Vertex nVertex = (Vertex) o[i];  
              
            if(i < (o.length - 1)){  
                System.out.print(nVertex.getName() + "->");  
            }
            else  {
                System.out.print(nVertex.getName());  
            }
            
            if(i<(o.length-1)){
            	//caculate the length
            	Vertex toVertex=(Vertex)o[i+1];
            	int to=getToVertexPos(toVertex);
            	currentEdge=nVertex.getEdgeNode();//get current EdgeNode 
            	while(true){
            		if(currentEdge.getIndexVertex()==to){
            			sumLength+=currentEdge.getWeight();
            			break;
            		}else{
            			currentEdge=currentEdge.getNextEdge();
            		}
            		if(currentEdge==null){
            			break;
            		}
            	}
            }
           
        }  
        System.out.print("  length:"+sumLength);
        length.add(sumLength);
        sers.add(o); // save   
        System.out.println("\n");  
    }
	
	public boolean getPaths(Vertex currentNode,Vertex preNode,Vertex start,Vertex end) {
		Vertex nextNode=null;
		if((currentNode!=null)&&(preNode!=null)&&(currentNode==preNode)) {
			return false;
		}

		if(currentNode!=null) {
			//add start in stack
			stack.push(currentNode);
			//if the start Node is the end , means success
			if(currentNode==end) {
				/*call method to save*/
				SavePath();
				return true;
			}else {
				//find first EdgeNode of Vertex
				EdgeNode currentEdge=currentNode.getEdgeNode();
				int nextVertexId=currentEdge.getIndexVertex();
				nextNode=graph.changePositionToVertex(nextVertexId);
				
				while(nextNode!=null) {
					if((preNode!=null)&&(nextNode==start||nextNode==preNode||isNodeInStack(nextNode))) {
						//find the next EdgeNoe in the linked list
						currentEdge=currentEdge.getNextEdge();
						//find nextEdge and then search
						//the current Edge has the information of the next vertex
						if(currentEdge==null) {
							nextNode=null;
						}else {
							nextVertexId=currentEdge.getIndexVertex();
							nextNode=graph.changePositionToVertex(nextVertexId);
						}
						continue;
					}
					//Recursively call itself in a loop
					if(getPaths(nextNode,currentNode,start,end)){
						//if getPaths return true means find a path and saved it,so we nedd return back the stack element
						stack.pop();
					}
					//if not find the path, change to next 
					if((currentEdge==null)||(currentEdge.getNextEdge()==null)) {
						nextNode=null;
					}else {
						currentEdge=currentEdge.getNextEdge();
						nextVertexId=currentEdge.getIndexVertex();
						nextNode=graph.changePositionToVertex(nextVertexId);
					}
					
				}
				
				//the nextNode is null means we need to back to the last node in stack
				stack.pop();
				return false;
				
			}
		}else {
			return false;
		}
	}
	
	//get the position of the vertex
	private int getToVertexPos(Vertex toVer){
		int pos=0;
		Vertex[] temp=graph.getVertexList();
		for(int i=0;i<temp.length;i++){
			if(toVer==temp[i]){
				pos=i;
			}
		}
		return pos;
	}
	
	//find vertex by name
	private Vertex findVertexByName(String name){
		Vertex node=null;
		Vertex[] head=graph.getVertexList();
		for(int i=0;i<head.length;i++){
			if(name==head[i].getName()){
				node=head[i];
			}
		}
		return node;
	}
}
