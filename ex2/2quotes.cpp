#include <chrono>
#include <condition_variable>
#include <fstream>
#include <iostream>
#include <mutex>
#include <queue>
#include <thread>

/**
 * @author Otávio Goes
 * @date 12/03/2020
 *
 * Faça uma thread que realize a leitura de um arquivo texto com frases e exiba
 * as frases a cada 10 segundos.
 */


/**
  * @brief  Faz a leitura do arquivo
  * @param  filename[]: name of file with quotes
  * @retval None
  */
std::ifstream& get_file(const char filename[]) {
  static std::ifstream file;
  file.open(filename);

  if (!file) {
    std::cerr << "Erro ao abrir o arquivo" << std::endl;
    exit(1);
  }

  return file;
}

void read_quotes(std::ifstream& file) {

  std::string quote;
  while(std::getline(file, quote)) {
    std::this_thread::sleep_for(std::chrono::seconds(10));
    std::cout << quote << std::endl;
  }

  std::cout << "A thread finalizou a leitura do arquivo." << std::endl;

  file.close();
}

int main (int argc, const char *argv[]) {

  if (argc != 2) {
    std::cerr << "Modo de usar: ./programa filename" << std::endl;
    exit(1);
  }


  std::ifstream& file = get_file(argv[1]);

  std::thread thread(read_quotes, file);

  thread.join();
  return 0;
}
