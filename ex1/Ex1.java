/**
 *@author Otávio Goes
 *@date 14/03/2020
 *@brief Create Three Threads with random time to sleep
 */

package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex1 {

  public static void main(final String[] args) {
    List<Thread> threads = new ArrayList<Thread>();
    int threadNumber = 3;

    for (int i = 0; i < threadNumber; ++i) {
      Runnable threadRunnable = () -> {
        try {

          int limitTime = 100;

          int timeWaiting = (new Random()).nextInt() % limitTime;
          // non-negative time
          timeWaiting = timeWaiting < 0 ? timeWaiting * (-1) : timeWaiting;

          Thread.sleep(timeWaiting);

          System.out.println("Thread[" + Thread.currentThread().getId() + "] - " + timeWaiting + "ms");

        } catch (InterruptedException exception) {
          System.out.println(exception);
        }
      };

      Thread thread = new Thread(threadRunnable);

      threads.add(thread);
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        // MainThread waits the created thread
        thread.join();
      } catch (InterruptedException exception) {
        System.out.println(exception);
      }
    }
  }
};
