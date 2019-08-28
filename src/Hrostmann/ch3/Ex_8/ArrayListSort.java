package Hrostmann.ch3.Ex_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Sorting massive by lucky method
 * @author Konstantin
 * @version 1.0
 */
public class ArrayListSort {
    /**
     * Shuffle ArrayList while ArrayList values will not be sorted in order specified by Comparator
     * @param strings ArrayList for sort
     * @param comp Comparator
     */
    public static <T> void luckySort(ArrayList<T> strings, Comparator<T> comp) {
        while(check(strings,comp))
            Collections.shuffle(strings);
    }
    /**
     * Checking values order in incoming ArrayList
     * @param strings ArrayList for check
     * @param comp Comparator
     * @return boolean value; true - means need to shuffle again, false - no needed, values in right order.
     */
    private static <T> boolean check(ArrayList<T> strings, Comparator<T> comp) {
        T buff = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            if (comp.compare(buff, strings.get(i)) >= 0)
                buff = strings.get(i);
            else
                return true;
        }
        return false;
    }
}
