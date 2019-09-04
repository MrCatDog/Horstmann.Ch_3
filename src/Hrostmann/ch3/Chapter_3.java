package Hrostmann.ch3;

import Hrostmann.ch3.Ex_8.*;
import Hrostmann.ch3.Ex_from_1_to_2.*;
import Hrostmann.ch3.Ex_from_4_to_6.*;
import Hrostmann.ch3.Ex_from_9_to_10.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *Base class to check all classes one by one
 * @author Konstantin
 * @version 1.0
 */
class Chapter_3 {
    public static void main(String[] args) {
        System.out.println("\nEx.1-2");
        ex1_2();
        System.out.println("\nEx.4-5");
        ex4_5();
        System.out.println("\nEx.6");
        ex6();
        System.out.println("\nEx.8");
        ex8();
        System.out.println("\nEx.9-10");
        ex9_10();
        System.out.println("\nEx.11-12");
        ex11_12();
        System.out.println("\nEx.13");
        ex13();
        System.out.println("\nEx.14");
        ex14(Chapter_3::ex1_2,System.out::println,Chapter_3::ex8).run();
        System.out.println("\nEx.15");
        ex15();
    }

    /**
     * Finding average measurable value.
     * @param objects massive from all measurable objects.
     * @return average value.
     */
    static private double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable i : objects)
            sum += i.getMeasure();
        return sum / objects.length;
    }

    /**
     * Finding largest by measurable parameter object from input.
     * @param objects massive from all measurable objects.
     * @return largest object from input massive.
     */
    static private Measurable largest(Measurable[] objects) {
        int largest = 0;
        for (int i = 1; i < objects.length; i++)
            if (objects[i].getMeasure() > objects[largest].getMeasure())
                largest = i;
        return objects[largest];
    }

    /**
     * Work with interfaces. Find the average and largest object by measurable parameters.
     * For <code>Employee</code> measurable parameter it's <code>salary</code>.
     * For <code>Book</code> measurable parameter it's <code>pages</code>.
     */
    static private void ex1_2() {
        //Ex.1
        Measurable[] measurables = new Measurable[3];
        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Fred", 55.6);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("John", 100);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Employee.hireEmployee("Emy", 110);
        System.out.println(average(measurables));
        Employee large = (Employee) largest(measurables);
        System.out.println(large.getName());

        //Ex.2
        measurables[0] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Fred's journey", 400);
        measurables[1] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("John's textbook", 234);
        measurables[2] = Hrostmann.ch3.Ex_from_1_to_2.Book.writeBook("Emy's journey", 347);
        System.out.println(average(measurables));
        Book large2 = (Book) largest(measurables);
        System.out.println(large2.getName());
    }

    /**
     * Making some <code>int</code> sequence.
     * First strongly defined, second draft randomly from represented numbers, third making constantly from one number.
     */
    static private void ex4_5() {
        //Ex.4
        IntSequence seq = IntSequence.of(1, 1, 1, 12, 3, 4, 5);
        while (seq.hasNext())
            System.out.println(seq.next());

        System.out.println();

        seq = IntSequence.of2(1, 2, 3, 4, 5, 6, 7);
        for (int i = 0; i < 10; i++)
            System.out.println(seq.next());

        //Ex.5
        seq = IntSequence.constant(73);
        for (int i = 0; i < 10; i++)
            System.out.println(seq.next());
    }

    /**
     * Work with some interfaces.
     * At first make <code>BigInteger</code> sequence, after that <code>Double</code>
     */
    static private void ex6() {
        Sequence seq = new SquareSequence();
        for (int i = 0; i < 3; i++)
            System.out.println(seq.next().toString());

        seq = new DoubleSquareSequence();
        for (int i = 0; i < 3; i++)
            System.out.println(seq.next());
    }

    /**
     * Sort string array by length with using shuffle method and <code>Comparator</code>.
     */
    static private void ex8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("once");
        list.add("told");
        list.add("me");
        list.add("Somebody");

        java.util.Comparator<String> comp = new LengthComparator();
        ArrayListSort.luckySort(list, comp);
        System.out.println(list);

        java.util.Comparator<Integer> comp2 = new LengthComparatorForInt();
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(68);
        list2.add(1);
        list2.add(145);
        ArrayListSort.luckySort(list2, comp2);
        System.out.println(list2);
    }

    /**
     * Runs first and second Greeter elements in parallel threads and, after that, one by one.
     */
    static private void ex9_10() {
        Greeter first = Greeter.greetMe("First", 7);
        Greeter second = Greeter.greetMe("Second", 5);
        Runnable together = new RunTogether(first, second);//run all greeter together.
        Runnable inOrder = new RunInOrder(first, second);//run all greeter one by one
        Thread th = new Thread(new RunInOrder(together, inOrder));//run together first, and then one by one
        th.start();
        try {
            th.join();//wait till the end (for not blending it with another Ex)
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Print all founded folders and files with ".pdf" extension in "D:/Fallout 2".
     */
    static private void ex11_12() {
        try {
            File dir = new File("D:/Fallout 2");
            File[] files = dir.listFiles(File::isDirectory);

            for (File i : files)
                System.out.println(i);

            String[] files2 = dir.list((File f, String name) -> name.endsWith(".pdf"));

            for (String i : files2)
                System.out.println(i);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Sort and print a list of Files. Folders on top, files on bottom, both sorted by path.
     */
    static private void ex13() {
        try {
            File[] files = {new File("D://Fallout 2"),
                    new File("D://Fallout 2/armor.ini"),
                    new File("D://Fallout 2/f2_res.dll"),
                    new File("D:/Fallout 2/DATA"),
                    new File("D://Git"),
                    new File("C://Program Files"),
                    new File("C:/Новая папка"),
                    new File("C:\\Program Files\\Java\\jdk-10.0.1"),
                    new File("C:\\Program Files\\Java\\jdk-10.0.1\\README.html"),
                    new File("C://error.notExist"),
                    new File("C:/FakeDir")
            };

            ArrayList<File> dirs = new ArrayList<>();
            ArrayList<File> obj = new ArrayList<>();

            for (File i : files)
                if (i.isDirectory())
                    dirs.add(i);
                else
                    obj.add(i);

            Thread th1 = new Thread(() -> dirs.sort(Comparator.comparing(File::getAbsolutePath)));
            th1.start();
            Thread th2 = new Thread(() -> obj.sort(Comparator.comparing(File::getAbsoluteFile)));
            th2.start();
            th1.join();
            th2.join();

            dirs.addAll(obj);

            for (File i : dirs)
                System.out.println(i);

        } catch (Exception e) {
            System.out.println("Ошибка при работе с файлом или потоком в задании 13:\n" + e.toString());
        }
    }

    /**
     * Run all <code>Runnable</code> objects one by one.
     * @param tasks <code>Runnable</code> objects for one by one execution.
     * @return <code>Runnable</code> object implements all tasks one by one.
     */
    static private Runnable ex14(Runnable... tasks) {
        return () -> {
            for (Runnable i : tasks) {
                i.run();
            }
        };
    }

    /**
     * Sort massive of <code>Employee</code> by <code>salary</code> and then by <code>name</code>,
     * after that sorts by <code>name</code> and then by <code>salary</code>.
     */
    static private void ex15() {
        Employee[] workesBees = {
                Employee.hireEmployee("First",45),
                Employee.hireEmployee("Legion",45),
                Employee.hireEmployee("Linda",45.5),
                Employee.hireEmployee("Shrek", 0),
                Employee.hireEmployee("RoboCop", 999.99),
                Employee.hireEmployee("Linda",65.7)
        };
        Comparator<Employee> comp = Comparator.comparing(Employee::getMeasure).reversed().thenComparing(Employee::getName);
        Arrays.sort(workesBees,comp);
        for(Employee i:workesBees)
            System.out.println(i.getName()+" "+i.getMeasure());
        System.out.println();

        Arrays.sort(workesBees,comp.reversed());
        for(Employee i:workesBees)
            System.out.println(i.getName()+" "+i.getMeasure());
    }

}