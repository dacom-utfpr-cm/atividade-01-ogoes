/**
 *@author Otávio Goes
 *@date 14/03/2020
 *@brief Create Three Threads with random time to sleep
 */

package ex1;

import java.util.ArrayList;
import java.util.List;


import base.WaitingThread;
public class Ex1 {

  public static void main(final String[] args) {
    List<Thread> threads = new ArrayList<Thread>();
    int threadNumber = 3;

    for (int i = 0; i < threadNumber; ++i) {

      Thread thread = new Thread(new WaitingThread());

      threads.add(thread);
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        // MainThread waits the created thread
        thread.join();
      } catch (InterruptedException exception) {
        System.out.println("Não foi possível fazer o join para a Thread: " + thread);
      }
    }
  }
};
