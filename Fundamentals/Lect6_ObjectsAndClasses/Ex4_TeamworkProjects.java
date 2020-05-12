/*
It`s time for teamwork projects and you are responsible for making the teams. First you will receive an integer - the
count of the teams you will have to register. You will be given a user and a team (separated with “-”). The user is
the creator of that team.
For every newly created team you should print a message:
"Team {team Name} has been created by {user}!".
Next you will receive user with team (separated with "->") which means that the user wants to join that team. Upon
receiving the command: “end of assignment”, you should print every team, ordered by the count of its
members (descending) and then by name (ascending). For each team (disband teams as well), you have to print its
members sorted by name (ascending). However, there are several rules:
 If user tries to create a team more than once a message should be displayed:
- "Team {teamName} was already created!"
 Creator of a team cannot create another team - message should be thrown:
- "{user} cannot create another team!"
 If user tries to join currently non-existing team a message should be displayed:
- "Team {teamName} does not exist!"
 Member of a team cannot join another team - message should be thrown:
- "Member {user} cannot join team {team Name}!"
 In the end (after teams` report) teams with zero members (with only a creator) should disband ordered by
name in ascending other.
 Every valid team should be printed ordered by name (ascending) in this format:
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class Ex4_TeamworkProjects {

    static class Team {
        private String creatorName;
        private String teamName;
        private List<String> allMember;

        public Team(String creatorName, String teamName, List<String> allMember) {
            this.creatorName = creatorName;
            this.teamName = teamName;
            this.allMember = allMember;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public String getTeamName() {
            return teamName;
        }

        public List<String> getAllMember() {
            return allMember;
        }

        int membersCount() {
            return allMember.size();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberTeams = Integer.parseInt(scanner.nextLine());

        List<Team> teams = new ArrayList<>();
        List<String> allowCreatorNames = new ArrayList<>();
        List<String> allowTeams = new ArrayList<>();

        for (int i = 1; i <= numberTeams; i++) {
            String[] lineTeam = scanner.nextLine().split("-");
            String creatorName = lineTeam[0];
            String teamName = lineTeam[1];

            if (i == 1) {
                Team team = new Team(creatorName, teamName, new ArrayList<>());
                teams.add(team);
                allowTeams.add(teamName);
                allowCreatorNames.add(creatorName);
                System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
            } else {
                boolean isTrue = true;
                if (allowTeams.contains(teamName)) {
                    System.out.printf("Team %s was already created!%n", teamName);
                    isTrue = false;
                }

                if (allowCreatorNames.contains(creatorName)) {
                    System.out.printf("%s cannot create another team!%n", creatorName);
                    isTrue = false;
                }

                if (isTrue) {
                    Team team = new Team(creatorName, teamName, new ArrayList<>());
                    teams.add(team);
                    allowTeams.add(teamName);
                    allowCreatorNames.add(creatorName);
                    System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
                }
            }

        }

        String command = scanner.nextLine();

        while (!command.equals("end of assignment")) {
            String[] lineMembers = command.split("->");
            String memberName = lineMembers[0];
            String teamName = lineMembers[1];

            boolean isTrue = true;
            if (!allowTeams.contains(teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
                isTrue = false;
            }
            if (allowCreatorNames.contains(memberName)) {
                System.out.printf("Member %s cannot join team %s!%n", memberName, teamName);
                isTrue = false;
            }

            for (Team team : teams) {
                if(team.getAllMember().contains(memberName)){
                    System.out.printf("Member %s cannot join team %s!%n", memberName, teamName);
                    isTrue = false;
                }
            }

            if (isTrue) {
                for (Team team : teams) {
                    if (team.getTeamName().equals(teamName)) {
                        team.getAllMember().add(memberName);
                    }
                }
            }
            command = scanner.nextLine();
        }

        teams = teams.stream()
                .sorted(Comparator.comparingInt(Team::membersCount).reversed().thenComparing(Team::getTeamName))
                .collect(Collectors.toList());

        for (Team team : teams) {
            if (team.getAllMember().size() != 0) {
                System.out.println(team.getTeamName());
                System.out.println("- " + team.getCreatorName());
                team.getAllMember().sort(String::compareTo);
                for (int i = 0; i < team.getAllMember().size(); i++) {
                    System.out.println("-- " + team.getAllMember().get(i));
                }
            }
        }

        List<String> teamsToDisband = new ArrayList<>();
        for (Team team : teams) {
            if(team.getAllMember().size() == 0){
                teamsToDisband.add(team.getTeamName());
            }
        }

        System.out.println("Teams to disband:");

        teamsToDisband
                .stream()
                .sorted()
                .forEach(System.out::println);

    }
}
