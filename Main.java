import java.util.concurrent.Semaphore;
import java.util.concurrent.*;

public class Main {

    public static void main(String args[]) {

        Semaphore semMike = new Semaphore(1);
        Semaphore semJack = new Semaphore(0);
        Semaphore semCarl = new Semaphore(0);

        Player mike = new Player("Mike", semMike, semJack, 1);
        Player jack = new Player("Jack", semJack, semCarl, 2);
        Player carl = new Player("Carl", semCarl, semMike, 3);

        Thread mikeTh = new Thread(mike);
        Thread jackTh = new Thread(jack);
        Thread carlTh = new Thread(carl);

        mikeTh.start();
        jackTh.start();
        carlTh.start();
    }

}
