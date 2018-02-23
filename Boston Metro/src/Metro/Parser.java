package Metro;

import Interfaces.EdgeADT;
import Interfaces.GraphADT;
import Interfaces.NodeADT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Ryan on 27/09/2016.
 */
public class Parser {

    private List<NodeADT> stations = new ArrayList<>();
    private List<EdgeADT> lines = new ArrayList<>();

    private List<String[]> adjNodes = new ArrayList<>();

    private GraphADT graph = new Graph();

    public GraphADT parse() {

        File file = new File("bostonmetro.txt");

        stations.add(0, null);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {

                StringTokenizer st = new StringTokenizer(line);

                String nodeID = st.nextToken();
                String nodeName = st.nextToken();

                String[] nodeObj = new String[3];

                while (st.hasMoreTokens()){

                    nodeObj[0] = st.nextToken();
                    nodeObj[1] = st.nextToken();
                    nodeObj[2] = st.nextToken();

                    String[] temp1 = new String[3];
                    String[] temp2 = new String[3];

                    temp1[0] = nodeObj[0];
                    temp1[1] = nodeObj[1];
                    temp1[2] = nodeID;

                    temp2[0] = nodeObj[0];
                    temp2[1] = nodeID;
                    temp2[2] = nodeObj[2];


                    adjNodes.add(temp1);
                    adjNodes.add(temp2);
                }

                Station station = new Station(Integer.parseInt(nodeID), nodeName);
                this.stations.add(station);


                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] objNode : adjNodes) {
            try {
                graph.addEdge(objNode[0], stations.get(Integer.parseInt(objNode[1])), stations.get(Integer.parseInt(objNode[2])));
            } catch (IndexOutOfBoundsException exception){
                exception.printStackTrace();
            }
        }

        graph.setStationList(stations);

        return graph;

    }


    public List<NodeADT> getStations() {

        return stations;
    }



    public List<EdgeADT> getLines() {
        return lines;
    }


}
