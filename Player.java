import java.util.concurrent.Semaphore;

public class Player implements Runnable {
    //Variable for player name
    String name;
    //Lock variable for the current player's turn
    Semaphore myTurn;
    //Lock variable for the next player's turn
    Semaphore nextTurn;
    //Variable for the time used for possessing the ball, unique to each player
    int time;

    //Assign values to the player
    public Player (String name,Semaphore myTurn, Semaphore nextTurn, int time) {
        this.name = name;
        this.myTurn = myTurn;
        this.nextTurn = nextTurn;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {

            try {
                //Current player acquires the lock
                myTurn.acquire();

                //Will have add an "s" to "second" if time is more than one second
                String sec = "";
                if (time > 1)
                    sec = "s";

                //Prints the current player who has the ball and the time taken for it's possession
                System.out.println(name + " takes the ball, runs for " + time + " second" + sec);

                //Puts the thread to sleep based on the ball possession time
                Thread.sleep(time*1000);

                //Releases the lock for the next player
                nextTurn.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
