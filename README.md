# Atividade-01 - Programação com threads

1. Faça um programa que inicie três threads e, cada
thread, espere um tempo aleatório para terminar.

2. Faça uma thread que realize a leitura de um arquivo
texto com frases e exiba as frases a cada 10 segundos.

3. Faça um programa que envia interrupções para as
threads dos exercı́cios anteriores. As threads devem fazer o
tratamento dessas interrupções e realizar uma finalização
limpa.

4. Faça uma thread que monitora um conjunto de threads e
exiba quais threads receberam sinais de interrupção.

5. Faça uma thread que fica aguardando uma sequência
numérica de tamanho arbitrário digitado por usuário para
realizar uma soma. Use o join().



## Como executar
Todos os comandos foram executados a partir do diretório base da atividade

#### ex1
```sh
$ javac ex1/Ex1.java base/WaitingThread.java && java ex1.Ex1
```

#### ex2
```sh
$ javac ex2/Ex2.java base/{NoArgumentException,FileReader}.java && java ex2.Ex2 base/quotes.txt
```

#### ex3
```sh
$ javac ex3/Ex3.java base/*.java && java ex3.Ex3 base/quotes.txt
```

#### ex4
```sh
$ javac ex4/Ex4.java base/*.java && java ex4.Ex4 base/quotes.txt
```

#### ex5
```sh
$ javac ex5/Ex5.java && java ex5.Ex5
```
