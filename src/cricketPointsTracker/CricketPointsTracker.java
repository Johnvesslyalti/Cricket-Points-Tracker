package cricketPointsTracker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class CricketPointsTracker {

    static class Team {
        String name;
        int matchesPlayed;
        int wins;
        int losses;
        int ties;
        int points;

        public Team(String name) {
            this.name = name;
            this.matchesPlayed = 0;
            this.wins = 0;
            this.losses = 0;
            this.ties = 0;
            this.points = 0;
        }

        public void updateStats(int win, int loss, int tie) {
            this.matchesPlayed += win + loss + tie;
            this.wins += win;
            this.losses += loss;
            this.ties += tie;
            this.points += (win * 2) + (tie * 1);
        }

        @Override
        public String toString() {
            return String.format("Team: %s | Matches: %d | Wins: %d | Losses: %d | Ties: %d | Points: %d",
                    name, matchesPlayed, wins, losses, ties, points);
        }
    }

    public static void displayPointsTable(HashMap<String, Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("No teams available to display.");
            return;
        }

        ArrayList<Team> sortedTeams = new ArrayList<>(teams.values());
        sortedTeams.sort(Comparator.comparingInt((Team t) -> t.points).thenComparingInt(t -> t.wins).reversed());

        System.out.println("\nCricket Points Table:");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Team", "Matches", "Wins", "Losses", "Ties", "Points");
        for (Team team : sortedTeams) {
            System.out.printf("%-15s %-15d %-15d %-15d %-15d %-15d\n",
                    team.name, team.matchesPlayed, team.wins, team.losses, team.ties, team.points);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Team> teams = new HashMap<>();

        while (true) {
            System.out.println("\nCricket Points Tracker Menu:");
            System.out.println("1. Add Team");
            System.out.println("2. Record Match Result");
            System.out.println("3. View Team Stats");
            System.out.println("4. View All Teams");
            System.out.println("5. Display Points Table");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter team name: ");
                    String teamName = scanner.nextLine();
                    if (!teams.containsKey(teamName)) {
                        teams.put(teamName, new Team(teamName));
                        System.out.println("Team added successfully.");
                    } else {
                        System.out.println("Team already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter winning team name (or 'None' for tie): ");
                    String winner = scanner.nextLine();
                    System.out.print("Enter losing team name (or 'None' for tie): ");
                    String loser = scanner.nextLine();

                    if (winner.equalsIgnoreCase("None") && loser.equalsIgnoreCase("None")) {
                        System.out.println("Invalid input for a match.");
                        break;
                    }

                    if (winner.equalsIgnoreCase("None")) {
                        if (teams.containsKey(loser)) {
                            System.out.print("Enter second team name for tie: ");
                            String tieTeam = scanner.nextLine();

                            if (teams.containsKey(tieTeam)) {
                                teams.get(loser).updateStats(0, 0, 1);
                                teams.get(tieTeam).updateStats(0, 0, 1);
                                System.out.println("Match recorded as tie.");
                            } else {
                                System.out.println("Second team not found.");
                            }
                        } else {
                            System.out.println("Team not found.");
                        }
                    } else {
                        if (teams.containsKey(winner) && teams.containsKey(loser)) {
                            teams.get(winner).updateStats(1, 0, 0);
                            teams.get(loser).updateStats(0, 1, 0);
                            System.out.println("Match result recorded.");
                        } else {
                            System.out.println("One or both teams not found.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter team name: ");
                    String searchTeam = scanner.nextLine();
                    if (teams.containsKey(searchTeam)) {
                        System.out.println(teams.get(searchTeam));
                    } else {
                        System.out.println("Team not found.");
                    }
                    break;

                case 4:
                    if (teams.isEmpty()) {
                        System.out.println("No teams available.");
                    } else {
                        System.out.println("\nAll Teams Stats:");
                        for (Team team : teams.values()) {
                            System.out.println(team);
                        }
                    }
                    break;

                case 5:
                    displayPointsTable(teams);
                    break;

                case 6:
                    System.out.println("Exiting Cricket Points Tracker. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
