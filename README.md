# Cricket Points Tracker

The **Cricket Points Tracker** is a Java-based command-line application designed to help users manage and track cricket team statistics, including points and match results. This application is ideal for tournament organizers and cricket enthusiasts who want to maintain an up-to-date points table.

## Features

1. **Add Teams**: Create and store cricket teams with unique names.
2. **Record Match Results**: Update match outcomes, including wins, losses, and ties.
3. **View Team Stats**: Display detailed statistics for a specific team.
4. **View All Teams**: List statistics for all teams in the system.
5. **Display Points Table**: Show a sorted table based on points and wins, providing a leaderboard.
6. **Exit**: Safely close the application.

## How to Run

1. **Prerequisites**:
   - Java Development Kit (JDK) installed (version 8 or above).
   - A Java IDE (e.g., IntelliJ IDEA, Eclipse) or terminal with `javac` and `java` commands available.

2. **Steps**:
   - Download the source code.
   - Open a terminal or command prompt.
   - Navigate to the directory containing the source file `CricketPointsTracker.java`.
   - Compile the code using the command:
     ```
     javac CricketPointsTracker.java
     ```
   - Run the program using the command:
     ```
     java CricketPointsTracker
     ```

## Usage Instructions

Upon running the program, you will see a menu with the following options:

1. **Add Team**:
   - Enter the name of the team to add it to the tracker.

2. **Record Match Result**:
   - Specify the winning and losing teams.
   - For a tied match, select "None" for the winner and provide the names of the tied teams.

3. **View Team Stats**:
   - Enter a team's name to display its matches played, wins, losses, ties, and total points.

4. **View All Teams**:
   - Display statistics for all teams currently in the tracker.

5. **Display Points Table**:
   - View a leaderboard sorted by points and wins.

6. **Exit**:
   - Safely exit the application.

## Points System

- **Win**: 2 points
- **Tie**: 1 point
- **Loss**: 0 points

## Example Output

```
Cricket Points Tracker Menu:
1. Add Team
2. Record Match Result
3. View Team Stats
4. View All Teams
5. Display Points Table
6. Exit
Choose an option: 5

Cricket Points Table:
Team            Matches        Wins           Losses         Ties           Points         
Team A          5              3              1              1              7              
Team B          5              2              2              1              5              
```

## Future Enhancements

- Add data persistence to save and load team data across sessions.
- Include support for Net Run Rate (NRR) calculations.
- Create a graphical user interface (GUI) for better usability.

## License

This project is open-source and available under the [MIT License](LICENSE).

