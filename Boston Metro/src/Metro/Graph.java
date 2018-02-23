package Metro;

import Interfaces.EdgeADT;
import Interfaces.GraphADT;
import Interfaces.NodeADT;

import java.util.*;

/**
 * Created by Darren on 06/10/2016.
 */
public class Graph implements GraphADT {

    public void setStationList(List<NodeADT> stationList) {
        this.stationList = stationList;
    }

    private List<NodeADT> stationList = new ArrayList<>();
    private final List<EdgeADT> lineList = new ArrayList<>();

    @Override
    public void addNode(int index, String name) {

        NodeADT n = new Station(index, name);

        stationList.add(n);
        assert stationList.contains(n) : "the node was not added to the station list";

    }

    @Override
    public void addEdge(String label, NodeADT adjNode1, NodeADT adjNode2) {

        EdgeADT e = new Line(label, adjNode1, adjNode2);

        lineList.add(e);
        assert lineList.contains(e) : "the edge was not added to the line list";

    }

    @Override
    public List<NodeADT> getListOfNodes() {

        List<NodeADT> temp;
        temp = stationList;
        return temp;

    }

    @Override
    public List<EdgeADT> getListOfEdges() {

        List<EdgeADT> temp;
        temp = lineList;
        return temp;

    }

    @Override
    public List getPath(String startNode, String endNode) {

        NodeADT node1 = null;
        NodeADT node2 = null;

        for (NodeADT node : stationList){
            if (node != null) {
                if (node.getName().equals(startNode)) {
                    node1 = node;
                } else if (node.getName().equals((endNode))) {
                    node2 = node;
                }
            }

            if (node1 != null && node2 != null){
                break;
            }

        }

        return getDirections(node1, node2);

    }


    private List<NodeADT> getChildren(NodeADT current){
        List<NodeADT> childNodes = new ArrayList<>();

        for (EdgeADT line : lineList){

            NodeADT node1 = line.getNodes().get(0);
            NodeADT node2 = line.getNodes().get(1);

            if (current.equals(node1) && node2 != null){
                childNodes.add(node2);
                assert childNodes.contains(node2) : "node 2 was not added to child nodes";
            }

            if (current.equals(node2) && node1 != null){
                childNodes.add(node1);
                assert childNodes.contains(node1) : "node 1 was not added to child nodes";
            }
        }

        return childNodes;
    }



    private final Map<NodeADT, Boolean> vis = new HashMap<>();

    private final Map<NodeADT, NodeADT> prev = new HashMap<>();


    private List getDirections(NodeADT start, NodeADT finish){
        List directions = new LinkedList();
        Queue q = new LinkedList();
        NodeADT current = start;
        q.add(current);
        vis.put(current, true);
        while(!q.isEmpty()){
            current = (NodeADT) q.remove();
            if (current.equals(finish)){
                break;
            }else{
                for(NodeADT node : getChildren(current)){

                    if(vis.get(node) == null){
                        q.add(node);
                        vis.put(node, true);
                        prev.put(node, current);
                    }
                }
            }
        }
        if (!current.equals(finish)){
            System.out.println("can't reach destination");
        }
        for(NodeADT node = finish; node != null; node = prev.get(node)) {
            directions.add(node);
        }

        return directions;
    }



    public boolean checkNodeExists(String nodeName){
        boolean found = false;

        for (NodeADT station : stationList)
        {
            if (station != null) {
                if (station.getName().equals(nodeName)) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }


}
