/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Create a Thread that read the file passed by param
 * */

package ex2;

import base.NoArgumentException;
import base.FileReader;

public class Ex2 {
  public static void main(final String[] args) throws NoArgumentException {

    if (args.length == 0) {
      throw new NoArgumentException("O caminho do arquivo deve ser passado por argumento");
    }
    String filePath = args[0];

    FileReader reader = new FileReader(filePath);
    Thread thread = new Thread(reader);
    thread.start();

    try {
      thread.join();
    } catch (InterruptedException exception) {
      System.out.println(exception);
    }
  }
}
