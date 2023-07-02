package designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Vertex<T> {
    private T data;
    private List<Vertex<T>> neighbours;

    public Vertex(T data) {
        this.data = data;
        neighbours = new ArrayList<>();
    }

    public Vertex(T data, List<Vertex<T>> neighbours) {
        this.data = data;
        this.neighbours = neighbours == null ? Collections.emptyList() : neighbours;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours.addAll(neighbours);
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        if (data != null ? !data.equals(vertex.data) : vertex.data != null) return false;
        return neighbours != null ? neighbours.equals(vertex.neighbours) : vertex.neighbours == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        int neighboursHash = neighbours.stream().mapToInt(Vertex::hashCode).sum();
        result = 31 * result + (neighbours != null ? neighbours.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + this.data + " -> " + this.neighbours + "]";
    }


}
