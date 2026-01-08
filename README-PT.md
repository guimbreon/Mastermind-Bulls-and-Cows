# Mastermind - Bulls and Cows Project

This README is also available in English. [Click here](README.md)

Project made by:
[Guilherme Soares](https://github.com/guimbreon) && [Vitória Correia](https://github.com/vitoriateixeiracorreia)

---
## Descrição do Jogo

**Mastermind** é um jogo de tabuleiro clássico em que um jogador, chamado **Mestre do Código**, cria um código secreto composto por uma sequência de quatro cores, escolhidas entre seis cores disponíveis. O segundo jogador, chamado **Quebra-Código**, tenta adivinhar o código por meio de uma série de tentativas. Após cada palpite, o Mestre do Código fornece um retorno na forma de dois números:

1. **a**: O número de cores na posição correta.  
2. **b**: O número de cores corretas, mas em posições erradas.

O objetivo do Quebra-Código é adivinhar o código secreto no menor número possível de tentativas.

A variante **Bulls and Cows** é semelhante ao Mastermind, mas usa apenas duas cores. Nessa variante, o retorno é dado como o número total de “Bulls” (cores corretas na posição correta) e “Cows” (cores corretas na posição errada).

## Descrição do Projeto

Este projeto simula o jogo **Mastermind** e sua variante **Bulls and Cows**. A funcionalidade principal inclui:

- **Geração do Código Secreto**: O Mestre do Código gera um código secreto.
- **Tentativas de Palpite**: O Quebra-Código tenta adivinhar o código, recebendo retorno após cada tentativa.
- **Retorno**: O retorno consiste em dois números: a quantidade de cores corretas na posição correta (a) e cores corretas na posição errada (b).
- **Rodadas do Jogo**: O Quebra-Código pode fazer várias tentativas, e o jogo exibe apenas as últimas 10.

### Principais Funcionalidades do Jogo

1. **Representação de Cores**: As cores são representadas por letras através de enumerações (`BinaryColour` e `MultiColour`), que implementam a interface `Colour`.
2. **Representação do Retorno**: O retorno é representado por dois inteiros (a e b) que indicam a correção do palpite.
3. **Tentativas Limitadas**: O número de tentativas é limitado pelas combinações possíveis, mas apenas as últimas 10 tentativas são exibidas.
4. **Mestre do Código Controlado pelo Computador**: O Mestre do Código é simulado pelo computador.

## Visão Geral do Código

O jogo é estruturado usando princípios de programação orientada a objetos, como herança, polimorfismo e encapsulamento. As seguintes classes e interfaces fazem parte do código:

### 1. **Classe `Code`**

- Representa o código secreto e implementa a interface `Cloneable`.
- Métodos incluem:
    - `getCode()`: Retorna uma cópia da sequência do código.
    - `getLength()`: Retorna o tamanho da sequência.
    - `howManyCorrect(CodeI other)`: Retorna um array com dois inteiros (a e b).
    - `clone()`: Cria uma cópia do objeto `Code`.
    - `equals(Object obj)`: Verifica se o código atual é igual a outro código.

### 2. **Classe `BullsAndCowsCode`**

- Estende a classe `Code` e é usada para a variante **Bulls and Cows**.
- Sobrescreve o método `howManyCorrect(CodeI other)` para fornecer retorno em termos de "Bulls" e "Cows".

### 3. **Interface `MastermindGame`**

- Define os métodos necessários para controlar o jogo, como:
    - `play(Code x)`: Realiza uma jogada e fornece o retorno.
    - `isRoundFinished()`: Verifica se a rodada acabou (ou seja, se o código foi adivinhado ou o número máximo de rodadas foi atingido).
    - `startNewRound()`: Inicia uma nova rodada com um novo código secreto.
    - `hint()`: Fornece uma dica ao jogador revelando uma cor aleatória do código.
    - `getNumberOfTrials()`: Retorna o número de tentativas realizadas até agora.
    - `bestTrial()`: Retorna a melhor tentativa com a pontuação mais alta.
    - `score()`: Retorna a pontuação atual.

### 4. **Classe `AbstractMastermindGame`**

- Classe abstrata que implementa a interface `MastermindGame`.
- Define métodos comuns ao jogo Mastermind e requer a implementação de detalhes específicos nas subclasses.
- Métodos incluem:
    - `score()`: Retorna a pontuação atual.
    - `updateScore()`: Atualiza a pontuação quando uma rodada termina.
    - `isRoundFinished()`: Verifica se a rodada acabou.
    - `toString()`: Fornece uma representação textual do estado do jogo.

### 5. **Classe `BullsAndCows`**

- Classe concreta que estende `AbstractMastermindGame` para a variante **Bulls and Cows**.
- Sobrescreve métodos como `score()`, `updateScore()` e `hint()` para ajustar às regras da variante.

### 6. **Classe `MultiColourMastermindGame`**

- Outra classe concreta que estende `AbstractMastermindGame` para a variante **Mastermind** com múltiplas cores.
- Implementa regras específicas de pontuação e fornece dicas ao jogador.

### 7. **Classe `Main`**

- Ponto de entrada principal do jogo.
- Lida com a entrada do usuário, executa o jogo e exibe os resultados no console.

## Como Executar o Jogo

1. Clone ou baixe o repositório.
2. Compile as classes usando sua IDE Java preferida ou uma ferramenta de build.
3. Execute a classe `Main` para começar a jogar.
4. O jogo interage com o usuário através do console, solicitando palpites e fornecendo retorno.

### Exemplo de Jogabilidade

```plaintext
Bem-vindo ao Mastermind!
O Mestre do Código gerou um código secreto. Tente adivinhar!

Tentativa 1: [Vermelho, Azul, Verde, Amarelo]
Retorno: a = 1, b = 2

Tentativa 2: [Verde, Azul, Vermelho, Amarelo]
Retorno: a = 3, b = 0

Você adivinhou o código secreto em 2 tentativas! Pontuação: 5000
```
