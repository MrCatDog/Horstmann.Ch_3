package Hrostmann.ch3.Ex_from_4_to_6;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private long i=0;
    public BigInteger next() {
        i++;
        return BigInteger.valueOf(i*i);}
}
