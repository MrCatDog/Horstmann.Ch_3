package Hrostmann.ch3.Ex_from_9_to_10;

import java.util.ArrayList;
import java.util.Arrays;

public class RunInOrder implements Runnable {
    private ArrayList<Runnable> tasks;

    public void run() {
        try {
            Thread th;
            for (Runnable i : this.tasks) {
                th = new Thread(i);
                th.start();
                th.join();
            }
        }
        catch(InterruptedException ex) {System.out.println(ex.toString());}
    }

    public RunInOrder(Runnable... tasks) {
        this.tasks.addAll(Arrays.asList(tasks));
    }
}
