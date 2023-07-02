package designpattern.behavioral.iterator;

public interface Tree<T> {
    Iterator<T> createBFSIterator();
    Iterator<T> createDFSIterator();
}
