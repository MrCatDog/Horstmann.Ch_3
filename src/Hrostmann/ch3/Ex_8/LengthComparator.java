package Hrostmann.ch3.Ex_8;

/**
 * Comparator for Strings by their length
 */
public class LengthComparator implements java.util.Comparator<String>{
    public int compare (String first, String second)
    {
        return first.length()-second.length();
    }
}
