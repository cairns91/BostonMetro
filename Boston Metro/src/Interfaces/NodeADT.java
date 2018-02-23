package Interfaces;

import java.util.List;

/**
 * Created by Ryan on 03/10/2016.
 */
public interface NodeADT {

    int getIndex();

    List<EdgeADT> getEdges();

    String getName();

}
