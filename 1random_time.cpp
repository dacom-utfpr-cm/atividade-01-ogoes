#include <time.h>

#include <cstdlib>
#include <iostream>
#include <thread>

/**
 * @author Otávio Goes
 * @date 12/03/2020
 * 
 * Faça um programa que inicie três threads e, cada thread, espere um tempo
 * aleatório para terminar.
 */

int main() {
  srand(time(NULL));

  std::thread thread1([]() {
    int time_to_wait = rand() % 100;
    std::this_thread::sleep_for(std::chrono::milliseconds(time_to_wait));
    std::cout << "Thread 1 acabou: " << time_to_wait << "ms" << std::endl;
  });

  std::thread thread2([]() {
    int time_to_wait = rand() % 100;
    std::this_thread::sleep_for(std::chrono::milliseconds(time_to_wait));
    std::cout << "Thread 2 acabou: " << time_to_wait << "ms" << std::endl;
  });

  std::thread thread3([]() {
    int time_to_wait = rand() % 100;
    std::this_thread::sleep_for(std::chrono::milliseconds(time_to_wait));
    std::cout << "Thread 3 acabou: " << time_to_wait << "ms" << std::endl;
  });

  thread1.join();
  thread2.join();
  thread3.join();

  return 0;
}
