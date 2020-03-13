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
std::vector<std::string> get_file_data(const char filename[]) {
  std::ifstream file;
  file.open(filename);

  if (!file) {
    std::cerr << "Erro ao abrir o arquivo" << std::endl;
    exit(1);
  }


  std::vector<std::string> lines;

  std::string quote;
  while (std::getline(file, quote)) {
    lines.push_back(quote);
  }

  file.close();

  return lines;
}

void show_quotes(std::vector<std::string> lines) {
  
  

  for (auto line: lines) {
    std::this_thread::sleep_for(std::chrono::seconds(10));
    std::cout << line << std::endl;
  }

  std::cout << "A thread finalizou a leitura do arquivo." << std::endl;
}

int main (int argc, const char *argv[]) {

  if (argc != 2) {
    std::cerr << "Modo de usar: ./programa filename" << std::endl;
    exit(1);
  }

  std::vector<std::string> file_data = get_file_data(argv[1]);

  std::thread thread(show_quotes, file_data);

  thread.join();
  return 0;
}
