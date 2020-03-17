/**
 *@author Otávio Goes
 *@date 17/03/2020
 *@brief Thread that waits a random amount of number and shows the sum of numbers
 */

package ex5;

import java.util.Random;
import java.util.Scanner;

public class NumberWaiting implements Runnable {

  public void run() {
    int numberAmount = ((new Random()).nextInt()  & 0x7fff) % 10;

    double sum = 0.0d;
    int iterator = 0;

    System.out.println("Informe " + numberAmount + " numero" +
                       (numberAmount > 1 ? "s" : "") + ":");

    Scanner inputScanner = new Scanner(System.in);
    while (iterator < numberAmount) {

      System.out.print("-> ");
      sum += inputScanner.nextDouble();
      ++iterator;
    }

    System.out.println("Resultado da soma: " + sum);
  };
};
