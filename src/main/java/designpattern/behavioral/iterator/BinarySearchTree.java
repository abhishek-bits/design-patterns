package designpattern.behavioral.iterator;

public class BinarySearchTree<T> implements Tree<T>{

    private Vertex<Integer> startVertex;

    public BinarySearchTree() {
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
