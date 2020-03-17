/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Interromps threads at work
 * */

package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import base.FileReader;
import base.NoArgumentException;
import base.WaitingThread;

public class Ex4 {

  public static Thread threadMonitor(List<Thread> threads) {
    Runnable monitorFunction = () -> {
      boolean hasThreadAlive = true;
      while (hasThreadAlive) {
        hasThreadAlive = false;
        int aSecond = 1000;
        try {
          Thread.sleep(aSecond);
        } catch (InterruptedException exception) {
        }

        for (Thread thread : threads) {
          boolean alive = thread.isAlive();
          hasThreadAlive |= alive;
          int id = threads.indexOf(thread);

          System.out.print("Thread[" + id + "] - ");
          if (alive) {
            System.out.println("Alive");
          } else {
            System.out.println("Finished or Interrupted");
          }
        }
        System.out.println();

      }
    };

    Thread monitorThread = new Thread(monitorFunction);
    monitorThread.start();
    return monitorThread;
  }

  public static void main(final String[] args) throws NoArgumentException {

    if (args.length == 0) {
      throw new NoArgumentException("O caminho do arquivo deve ser passado por argumento");
    }

    List<Thread> threads = new ArrayList<Thread>();

    String filePath = args[0];
    Thread readerThread = new Thread(new FileReader(filePath));

    int waitingThreadNumber = 3;
    for (int iterator = 0; iterator < waitingThreadNumber; ++iterator) {
      Thread waitingThread = new Thread(new WaitingThread());
      threads.add(waitingThread);
      // waitingThread.start();
    }
    threads.add(readerThread);


    List<Thread> fakeThreads = new ArrayList<Thread>();
    for (Thread thread : threads) {
      thread.start();

      Random randomObject = new Random();

      Runnable interruptRunnable = () -> {
        int seconds = (randomObject.nextInt() % 1) & 0x7fff; // waits less then ten seconds
        int millis = (randomObject.nextInt() % 1000) & 0x7fff;

        int timeWaiting = (seconds * 1000) + millis;

        try {
          Thread.sleep(timeWaiting);
        } catch (InterruptedException exception) {
        }

        while (thread.isAlive()){
          thread.interrupt();
        }
      };

      Thread fake = new Thread(interruptRunnable);
      fakeThreads.add(fake);
      fake.start();
    }

    Thread monitor = Ex4.threadMonitor(threads);

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException exception) {
      }
    }
    for (Thread fake : fakeThreads) {
      try {
        fake.join();
      } catch (InterruptedException exception) {
      }
    }

    try {
      monitor.join();
    } catch (InterruptedException exception) {
    }

    System.out.println("All Threads has been finished!");
  }
}
