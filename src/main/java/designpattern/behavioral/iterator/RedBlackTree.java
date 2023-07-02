package designpattern.behavioral.iterator;

import java.util.Vector;

public class RedBlackTree<T> implements Tree<T> {

    private Vertex<Integer> startVertex;

    public RedBlackTree() {
        startVertex = new Vertex<>(0);
    }

    @Override
    public Iterator<T> createBFSIterator() {
        return new BreadthFirstIterator(startVertex);
    }

    @Override
    public Iterator<T> createDFSIterator() {
        return new DepthFirstIterator(startVertex);
    }
}
