package Metro;

import Interfaces.EdgeADT;
import Interfaces.NodeADT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 29/09/2016.
 */
public class Line implements EdgeADT {

    public String getLabel() {
        return label;
    }

    private String label;
    private NodeADT leftNode;
    private NodeADT rightNode;


    public Line(String label, NodeADT adjNode1, NodeADT adjNode2){
        this.label = label;
        this.leftNode = adjNode1;
        this.rightNode = adjNode2;
    }


    @Override
    public List<NodeADT> getNodes() {

        List<NodeADT> childNodes = new ArrayList<>();

        childNodes.add(leftNode);
        childNodes.add(rightNode);

        return childNodes;

    }
}
