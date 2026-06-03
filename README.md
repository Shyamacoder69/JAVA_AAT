# JAVA_AAT
# Game Management System

## Aim
To develop a Java console-based Game Management System that allows a player to register, play simple games, store match history, and generate statistical reports using core Java concepts.

## Introduction
Game Management System is a beginner-friendly console application designed for a Core Java mini-project. The system manages one player profile and supports two games: Stone Paper Scissors and Guess the Number. It records each match, stores result history, and prepares game-wise and overall statistics.

## Objectives
- To understand package-based project organization in Java.
- To implement interface-based game abstraction.
- To use collections for storing and processing game records.
- To practice exception handling for invalid user input.
- To apply object-oriented programming principles in a real mini-project.
- To generate reports using StringBuilder.

## Technologies Used
- Java
- JDK 8 or above
- Console / Command Line
- Collections Framework

## Java Concepts Used
- Packages
- Interface
- Classes and Objects
- Encapsulation
- Abstraction
- Polymorphism
- Vector
- Arrays
- Generics
- Enum
- Exception Handling
- Wrapper Classes
- Boxing and Unboxing
- StringBuilder
- Random class

## Package and Class Explanation

### 1. `games/Game.java`
This interface defines the common behavior for all games. Every game must provide its name and implement the `play()` method.

### 2. `games/StonePaperScissors.java`
This class implements the `Game` interface. It allows the player to choose Stone, Paper, or Scissors and compares that choice with a computer-generated move.

### 3. `games/GuessNumber.java`
This class also implements the `Game` interface. It generates a random number and gives the player limited attempts to guess it.

### 4. `player/Player.java`
This class stores player data such as ID, name, age, and city. It uses private data members with getters and setters to demonstrate encapsulation.

### 5. `history/GameHistory.java`
This class stores one game session's details, including game name, result, description, and timestamp.

### 6. `history/StatsManager.java`
This class analyzes the history stored in `Vector<GameHistory>` and creates a statistics report using `StringBuilder`.

### 7. `Main.java`
This is the driver class of the application. It shows the menu, handles user input, calls game objects, and displays profile, history, and statistics.

## System Modules
1. Player Registration Module
2. Game Selection Module
3. Stone Paper Scissors Module
4. Guess the Number Module
5. Match History Module
6. Statistics Module
7. Exit Module

## Working of the Project
1. The user starts the program.
2. The main menu is displayed.
3. The player is first registered by entering ID, name, age, and city.
4. The player selects either Stone Paper Scissors or Guess the Number.
5. The game result is decided by the system.
6. Each played match is stored in `Vector<GameHistory>`.
7. The user can view profile, match history, and statistics at any time.
8. The application exits when the user chooses option 7.

## Project Synopsis
The Game Management System is a console-based Java application developed for academic mini-project purposes. It helps manage a player's information and gameplay activities in a structured way. The project supports two games and stores all match records in memory. The program demonstrates the practical use of core Java concepts such as packages, interfaces, collections, enums, exception handling, arrays, vectors, generics, and object-oriented programming.

## Team Members Contribution
- Member 1: Designed the class structure and package organization.
- Member 2: Implemented the Stone Paper Scissors module.
- Member 3: Implemented the Guess the Number module.
- Member 4: Developed history tracking, statistics reporting, and testing.

## Advantages
- Simple and easy to understand.
- Suitable for beginners and laboratory demonstration.
- Uses multiple important Core Java concepts in one project.
- Modular design makes the code reusable and maintainable.
- Can be expanded by adding more games.

## Limitations
- Data is stored only in memory and is lost after program exit.
- Only one player profile is managed at a time.
- No graphical user interface.
- Limited to two games.

## Future Enhancements
- Add file handling or database storage.
- Support multiple players and login system.
- Add more games.
- Create a GUI using Java Swing or JavaFX.
- Add scoreboards and leaderboard support.

## Conclusion
This project is a compact and effective Core Java mini-project for college students. It demonstrates essential Java concepts in a practical way and provides a clear example of modular, object-oriented console application development.

## Compilation and Execution
From the parent folder containing `GameManagementSystem`, run:

```bash
javac Main.java games/*.java player/*.java history/*.java
java Main
```