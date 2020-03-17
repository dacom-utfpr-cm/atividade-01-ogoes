/**
 *@author Otávio Goes
 *@date 14/03/2020
 *@brief Create Three Threads with random time to sleep
 */

package base;

import java.util.Random;

public class WaitingThread implements Runnable {

  private static long classId = 0;
  private long threadId;

  private int seconds, millis;

  private boolean randomTime = true;

  public WaitingThread() {
    this.threadId = WaitingThread.classId;
    WaitingThread.classId += 1;
  }

  /**
   * maximum sleep time limitation defined by seconds and milliseconds
   */
  public WaitingThread(int seconds, int millis) {
    
    this.threadId = WaitingThread.classId;
    WaitingThread.classId += 1;
    
    this.millis = millis;
    this.seconds = seconds;

    this.randomTime = false;
  }

  @Override
  public void run() {
    try {

      Random randomObject = new Random();

      if (this.randomTime) {
        this.seconds = (randomObject.nextInt() % 60) & 0x7fff; // waits less then a minute
        this.millis = (randomObject.nextInt() % 1000) & 0x7fff;
      }

      int timeWaiting = (this.seconds * 1000) + this.millis;
      // non-negative time

      System.out.println("Thread[" + this.threadId + "] - " + timeWaiting + "ms");
      Thread.sleep(timeWaiting);
      System.out.println("Thread[" + this.threadId + "] Finalizada");

    } catch (InterruptedException exception) {
      System.out.println("Thread[" + this.threadId + "] Iterrompida");
    }


  }

}
