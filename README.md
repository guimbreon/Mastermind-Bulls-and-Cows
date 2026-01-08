# Mastermind - Bulls and Cows Project

Também pode consultar este README em português. [Click here](README-PT.md)
Project made by:
[Guilherme Soares](https://github.com/guimbreon) && [Vitória Correia](https://github.com/vitoriateixeiracorreia)
---
## Game Description

**Mastermind** is a classic board game where one player, called the **CodeMaster**, creates a secret code consisting of a sequence of four colors, selected from six available colors. The second player, called the **CodeBreaker**, tries to guess the code through a series of attempts. After each guess, the CodeMaster provides feedback in the form of two numbers:

1. **a**: The number of colors in the correct position.
2. **b**: The number of colors that are correct but in the wrong position.

The goal of the CodeBreaker is to guess the secret code in the fewest attempts possible.

The variant **Bulls and Cows** is similar to Mastermind but only uses two colors. In this variant, feedback is given as the total number of "Bulls" (correct colors in the correct position) and "Cows" (correct colors but in the wrong position).

## Project Description

This project simulates the **Mastermind** game and its **Bulls and Cows** variant. The core functionality includes the following:

- **Secret Code Generation**: The CodeMaster generates a secret code.
- **Guessing Attempts**: The CodeBreaker attempts to guess the code, receiving feedback after each attempt.
- **Feedback**: The feedback consists of two numbers: the count of correct colors in the correct position (a) and correct colors in the wrong position (b).
- **Game Rounds**: The CodeBreaker can make multiple attempts, and the game tracks the last 10 guesses.

### Key Game Features

1. **Color Representation**: The colors are represented as letters through enumerations (`BinaryColour` and `MultiColour`), which implement the `Colour` interface.
2. **Feedback Representation**: The feedback is represented by two integers (a and b) that indicate the correctness of the guess.
3. **Limited Attempts**: The number of attempts is limited by the number of possible combinations, but only the last 10 attempts are shown.
4. **Computer-Controlled CodeMaster**: The CodeMaster is simulated by the computer.

## Code Overview

The game is structured using object-oriented principles like inheritance, polymorphism, and encapsulation. The following classes and interfaces are part of the code:

### 1. **`Code` Class**

- This class represents the secret code and implements the `Cloneable` interface.
- Methods include:
    - `getCode()`: Returns a copy of the code sequence.
    - `getLength()`: Returns the length of the code sequence.
    - `howManyCorrect(CodeI other)`: Returns an array with two integers (a and b).
    - `clone()`: Creates a clone of the current `Code` object.
    - `equals(Object obj)`: Checks if the current code is equal to another code.

### 2. **`BullsAndCowsCode` Class**

- This class extends the `Code` class and is used for the **Bulls and Cows** variant.
- It overrides the `howManyCorrect(CodeI other)` method to provide feedback in terms of "Bulls" and "Cows".

### 3. **`MastermindGame` Interface**

- Defines the methods necessary to control the game, such as:
    - `play(Code x)`: Makes a move and provides feedback.
    - `isRoundFinished()`: Checks if the round is over (i.e., the code is guessed or the maximum number of rounds is reached).
    - `startNewRound()`: Starts a new round with a new secret code.
    - `hint()`: Provides a hint to the player by revealing a random color from the secret code.
    - `getNumberOfTrials()`: Returns the number of attempts made so far.
    - `bestTrial()`: Returns the best trial with the highest score.
    - `score()`: Returns the current score.

### 4. **`AbstractMastermindGame` Class**

- An abstract class that implements the `MastermindGame` interface.
- This class defines common methods for the Mastermind game and requires the implementation of specific details in subclasses.
- Methods include:
    - `score()`: Returns the current score.
    - `updateScore()`: Updates the score when a round finishes.
    - `isRoundFinished()`: Checks if the round is finished.
    - `toString()`: Provides a textual representation of the game state.

### 5. **`BullsAndCows` Class**

- A concrete class that extends `AbstractMastermindGame` for the **Bulls and Cows** variant.
- It overrides methods such as `score()`, `updateScore()`, and `hint()` to adjust for the rules of Bulls and Cows.

### 6. **`MultiColourMastermindGame` Class**

- Another concrete class that extends `AbstractMastermindGame` for the **Mastermind** variant with multiple colors.
- This class implements specific rules for scoring and provides a hint to the player.

### 7. **`Main` Class**

- The main entry point for the game.
- It handles user input, runs the game, and outputs the results to the console.

## How to Run the Game

1. Clone or download the repository.
2. Compile the classes using your preferred Java IDE or build tool.
3. Run the `Main` class to start playing the game.
4. The game will interact with the user through the console, prompting for guesses and providing feedback.

### Example of Gameplay

```plaintext
Welcome to Mastermind!
The CodeMaster has generated a secret code. Try to guess it!

Attempt 1: [Red, Blue, Green, Yellow]
Feedback: a = 1, b = 2

Attempt 2: [Green, Blue, Red, Yellow]
Feedback: a = 3, b = 0

You guessed the secret code in 2 attempts! Score: 5000
```
___
