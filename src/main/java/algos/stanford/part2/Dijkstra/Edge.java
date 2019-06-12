package algos.stanford.part2.Dijkstra;

import java.util.Comparator;

public class Edge implements Comparator<Edge> {

    public Edge(Integer startVertex, Integer targetVertex, Integer distance) {
        this.targetVertex = targetVertex;
        this.startVertex = startVertex;
        this.distance = distance;
    }

    public Edge() {
    }


    public Integer getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Integer targetVertex) {
        this.targetVertex = targetVertex;
    }

    public Integer getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Integer startVertex) {
        this.startVertex = startVertex;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    private Integer targetVertex;
    private Integer startVertex;
    private Integer distance;


    @Override
    public int compare(Edge o1, Edge o2) {
        if (o1.getDistance() < o2.getDistance())
            return -1;
        if (o1.getDistance() > o2.getDistance())
            return 1;
        return 0;
    }
}
