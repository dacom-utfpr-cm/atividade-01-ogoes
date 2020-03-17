/**
 *@author Otávio Goes
 *@date 17/03/2020
 *@brief Wait thread collect random number with join method
 */

package ex5;

public class Ex5 {
	public static void main(final String[] args) {
		Thread numberSumThread = new Thread(new NumberWaiting());
		numberSumThread.start();

		try {
			numberSumThread.join();
		} catch (InterruptedException exception) {
			System.out.println("Não foi possível esperar o término da execução da thread. " + exception);
		}
	}
};
