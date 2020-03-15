/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Read the file, wait 10 seconds to show each quote
 * */

package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Runnable {

  private final String filePath;

  FileReader(final String filePath) {
    this.filePath = filePath;
  }

  @Override
  public void run() {

    final File file = new File(this.filePath);


    if (file.exists() && file.isFile() && file.canRead()) {

      try {
        Scanner reader = new Scanner(file);

        final long sleepTime = 10; // seconds
        final long timeFactor = 1000; // milliseconds, sleep mathod waits a value as milliseconds

        while (reader.hasNextLine()) {
          final String data = reader.nextLine();
          System.out.println(data);

          try {
            Thread.sleep(sleepTime * timeFactor);
          } catch (InterruptedException exception) {
            System.out.println("Thread leitora de arquivos interrompida");
            reader.close();
            break;
          }
        }

        reader.close();
      } catch (final FileNotFoundException exception) {
        System.out.println(exception);
      }

    }
  }
}
