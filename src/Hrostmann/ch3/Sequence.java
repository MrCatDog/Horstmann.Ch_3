package Hrostmann.ch3;

public interface Sequence<T> {
    default boolean hasNext() {return true;}
    T next();
}
