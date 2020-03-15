/**
 *@author Otávio Goes
 *@date 15/03/2020
 *@brief Read the file, wait 10 seconds to show each quote
 * */

package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Runnable {

  private String filePath;

  FileReader(String filePath) {
    this.filePath = filePath;
  }

  public void run() {

    File file = new File(this.filePath);

    System.out.println("Working Directory = " + System.getProperty("user.dir"));

    if (file.exists() && file.isFile() && file.canRead()) {
      try {
        Scanner reader = new Scanner(file);

        long sleepTime = 10; // seconds
        long timeFactor = 1000; // milliseconds, sleep mathod waits a value as milliseconds

        while (reader.hasNextLine()) {
          String data = reader.nextLine();
          System.out.println(data);

          try {
            Thread.sleep(sleepTime * timeFactor);

          } catch (InterruptedException exception) {
            System.out.println(exception);
          }

        }
        reader.close();
      } catch (FileNotFoundException exception) {
        System.out.println(exception);
      }

    }
  }
}
