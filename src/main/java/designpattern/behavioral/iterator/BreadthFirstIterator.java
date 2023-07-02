package designpattern.behavioral.iterator;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstIterator<T>  implements Iterator<T> {

    private final Vertex<T> startVertex;
    private Queue<Vertex<T>> queue = new ArrayDeque<>();
    private Set<Vertex<T>> visited = new HashSet<>();

    public BreadthFirstIterator(Vertex<T> startVertex) {
        this.startVertex = startVertex;
        queue.offer(startVertex);
        visited.add(startVertex);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Vertex<T> getNext() {
        Vertex<T> current = queue.remove();
        current.getNeighbours().forEach(neighbour -> {
            // enqueue each element if not already exists
            if(!visited.contains(neighbour)) {
                visited.add(neighbour);
                queue.offer(neighbour);
            }
        });
        // return the current element.
        return current;
    }

    @Override
    public void reset() {
        visited.clear();
        visited.add(startVertex);
        queue.clear();
        queue.offer(startVertex);
    }
}
