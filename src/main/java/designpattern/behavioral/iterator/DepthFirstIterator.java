package designpattern.behavioral.iterator;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DepthFirstIterator<T> implements Iterator<T>{

    private final Vertex<T> startVertex;
    private Deque<Vertex<T>> stack = new LinkedList<>();
    private Set<Vertex<T>> visited = new HashSet<>();

    public DepthFirstIterator(Vertex<T> startVertex) {
        this.startVertex = startVertex;
        stack.push(startVertex);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Vertex<T> getNext() {
        Vertex<T> current = stack.pop();
        if(!visited.contains(current)) {
            // This is the first time we are seeing this vertex
            // we'll traverse this branch first.
            visited.add(current);
            current.getNeighbours().forEach(stack::push);
            return current;
        }
        // backtrack and get the remaining vertices.
        return getNext();
    }

    @Override
    public void reset() {
        visited.clear();
        stack.clear();
        stack.push(startVertex);
    }
}
