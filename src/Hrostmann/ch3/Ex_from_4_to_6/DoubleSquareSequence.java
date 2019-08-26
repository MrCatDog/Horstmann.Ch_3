package Hrostmann.ch3.Ex_from_4_to_6;

public class DoubleSquareSequence implements Sequence<Double> {

    private double i=0;

    public Double next() {
        i+=0.1;
        return i*i;
    }
}
