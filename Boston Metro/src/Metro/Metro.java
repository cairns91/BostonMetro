package Metro;

import Interfaces.EdgeADT;
import Interfaces.GraphADT;
import Interfaces.NodeADT;

import java.util.*;

/**
 * Created by Ryan on 22/09/2016.
 */
public class Metro {

    public Metro() {

        Parser parser = new Parser();

        GraphADT graph = parser.parse();

        String startNode = "";
        String endNode = "";

        // Used for user input

        Scanner s = new Scanner(System.in);

        System.out.println("Remember to enter the station names without spaces");
        System.out.println("----------");

        while (graph.checkNodeExists(startNode) != true) {
            System.out.print("Enter a valid Starting Destination: ");
            startNode = s.next();
        }

        while (graph.checkNodeExists(endNode) != true) {
            System.out.print("Enter a valid Final Destination: ");
            endNode = s.next();
        }




        createPath(graph, startNode, endNode);


    }

    private void createPath(GraphADT graph, String startNode, String endNode){

        List<NodeADT> path = graph.getPath(startNode, endNode);

        Collections.reverse(path);

        int i = 0;

        String currentLine = "";
        String newLine = "";

        for (NodeADT station : path) {

            i++;

            if (i != path.size()){

                NodeADT nxtNode = path.get(i);

            List<EdgeADT> edges = graph.getListOfEdges();

            for (EdgeADT edge : edges) {
                List<NodeADT> nodes = edge.getNodes();

                boolean node1 = false;
                boolean node2 = false;

                for (NodeADT node : nodes) {

                    if (station.equals(node))
                        node1 = true;

                    if (nxtNode.equals(node))
                        node2 = true;

                }

                if (node1 && node2) {
                    newLine = edge.getLabel();
                }

            }
                if (i == 1){
                    System.out.println("Get on at " + path.get(0).getName() + " on the " + newLine + " Line");
                    currentLine = newLine;

                }
                   else {
                     if (!currentLine.equals(newLine)) {
                        currentLine = newLine;
                        System.out.println(station.getName() + " change to " + newLine);
                 }
}

        }

        }

        System.out.println("Arrive at " + path.get(path.size()-1).getName());


    }


}
