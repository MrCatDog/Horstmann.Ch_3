package Hrostmann.ch3.Ex_8;

import java.util.Comparator;

/**
 * Comparator for Integers by theirs length
 */
public class LengthComparatorForInt implements Comparator<Integer> {

    public int compare(Integer first, Integer second) {
        return first.toString().length()-second.toString().length();
    }
}
