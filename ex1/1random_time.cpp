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

  long int thread_number = 3;

  std::thread threads[thread_number];

  for (long int i = 0; i < thread_number; ++i)
    threads[i] = std::thread([i]() {
      int time_to_wait = rand() % 100;

      std::this_thread::sleep_for(std::chrono::milliseconds(time_to_wait));

      std::cout << "Thread " << i << " acabou: " << time_to_wait << "ms"
                << std::endl;
    });

  for (auto &thread : threads) {
    if (thread.joinable()) thread.join();
  }

  return 0;
}
