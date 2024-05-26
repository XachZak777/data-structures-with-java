package Tree;

import List.Position;

public interface BinaryTree<E> extends Tree<E> { 

    Position<E> left (Position<E> p) throws IllegalArgumentException;

    Position<E> right (Position<E> p) throws IllegalArgumentException;

    Position<E> siling (Position<E> p) throws IllegalArgumentException;
    
}
