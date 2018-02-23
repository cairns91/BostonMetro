package Metro;

import Interfaces.EdgeADT;
import Interfaces.NodeADT;

import java.util.List;

/**
 * Created by Ryan on 22/09/2016.
 */
public class Station implements NodeADT {

    private int index;

    public String getName() {
        return name;
    }

    private String name;

    public Station(int index, String name){
        this.index = index;
        this.name = name;
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public List<EdgeADT> getEdges() {
        return null;
    }

}
