import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Leetcode1226 {
    private Semaphore mutex;
    private List<Semaphore> fork;
    public Leetcode1226() {
        mutex = new Semaphore(1);
        fork = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fork.add(new Semaphore(1));
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher, right = (philosopher + 1) % 5;

        mutex.acquire();
        fork.get(left).acquire();
        fork.get(right).acquire();
        mutex.release();
        /*
        if (left % 2 == 1) {
            fork.get(left).acquire();
            fork.get(right).acquire();
        }
        else {
            fork.get(right).acquire();
            fork.get(left).acquire();
        }
        */
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();
        
        fork.get(left).release();
        fork.get(right).release();
    }
}