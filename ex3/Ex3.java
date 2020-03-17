/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Interromps threads at work
 * */

package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import base.FileReader;
import base.NoArgumentException;
import base.WaitingThread;

public class Ex3 {
  public static void main(final String[] args) throws NoArgumentException {

    if (args.length == 0) {
      throw new NoArgumentException("O caminho do arquivo deve ser passado por argumento");
    }

    List<Thread> threads = new ArrayList<Thread>();

    String filePath = args[0];
    Thread readerThread = new Thread(new FileReader(filePath));
    // threads.add(readerThread);
    readerThread.start();

    int waitingThreadNumber = 3;
    for (int iterator = 0; iterator < waitingThreadNumber; ++iterator) {
      Thread waitingThread = new Thread(new WaitingThread());
      threads.add(waitingThread);
      waitingThread.start();
    }

    for (Thread thread : threads) {
      thread.interrupt();
    }

    try {

      int bottomTime = 20;
      int limitTime = 50;

      int tmpUnsignedInt = (new Random()).nextInt() & 0x7fff;

      int timeWaiting = (tmpUnsignedInt % (limitTime - bottomTime)) + bottomTime;
      // non-negative time

      // Espera de 20 a 50 segundos para interromper a thread que está lendo o arquivo
      System.out.println(timeWaiting + "s para interromper a thread leitora");
      Thread.sleep(timeWaiting * 1000);
    } catch (InterruptedException exception) {
      System.out.println("Main Thread interropida durante o sleep");
    }
    readerThread.interrupt();

  }
}
