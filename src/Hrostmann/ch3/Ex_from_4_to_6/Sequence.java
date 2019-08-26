package Hrostmann.ch3.Ex_from_4_to_6;

public interface Sequence<T> {
    default boolean hasNext() {return true;}
    T next();
}
