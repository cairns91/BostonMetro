package Interfaces;

import java.util.List;

/**
 * Created by Ryan on 22/09/2016.
 */
public interface GraphADT {

   // TODO make an object to store node data in one parameter.

   /**
    * @param name the name of the node e.g. OakGrove Station.
    */
    void addNode(int index, String name);

   /**
    * @param label the label of the edge
    * @param adjNode1 the first adjacent node
    * @param adjNode2 the second adjacent node
    */
    void addEdge(String label, NodeADT adjNode1, NodeADT adjNode2);

    List<NodeADT> getListOfNodes();

    List<EdgeADT> getListOfEdges();
    
   /**
    * @param startNode the node to start path from
    * @param endNode the node to end the path at
    */
    List getPath(String startNode, String endNode);

    void setStationList(List<NodeADT> list);

    boolean checkNodeExists(String startNode);
}
