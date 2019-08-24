package Hrostmann.ch3;

import java.util.Random;

public interface IntSequence {

    Random rand = new Random();

    int next();
    default boolean hasNext() {return true;}

    static IntSequence of(int... values) {
        return new IntSequence() {
            int i =-1;

            public int next() {
                return values[++i];
            }

            public boolean hasNext() {
                return values.length-1>i;
            }
        };
    }

    static IntSequence of2(int... values) {
        return () -> values[rand.nextInt(values.length)];
    }

    static IntSequence constant(int value)
    {
        return () -> value;
    }
}