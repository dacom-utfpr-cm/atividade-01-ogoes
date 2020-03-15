/**
 *@author Otávio Goes
 *@date 14/03/2020
 *@brief Create Three Threads with random time to sleep
 */

package ex3;

import java.util.Random;

public class WaitingThread implements Runnable {

  private static long classId = 0;
  private long threadId;

  WaitingThread() {
    this.threadId = WaitingThread.classId;
    WaitingThread.classId += 1;
  }

  @Override
  public void run() {
    try {

      int limitTime = 100;

      int timeWaiting = (new Random()).nextInt() % limitTime;
      // non-negative time
      timeWaiting = timeWaiting < 0 ? timeWaiting * (-1) : timeWaiting;

      Thread.sleep(timeWaiting);

      System.out.println("Thread[" + this.threadId + "] - " + timeWaiting + "ms");

    } catch (InterruptedException exception) {
      System.out.println("Thread[" + this.threadId + "] Iterrompida");
    }
  }

}
