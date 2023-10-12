package org.example.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class GroupOfTeams {
    private List<Team> teams;
    private double standardDeviation;
    public GroupOfTeams(List<Person> personList, int numberOfTeams) {
        teams = new ArrayList<>(numberOfTeams);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams.size(); i++) {
            sb.append("Team no ")
                    .append(i + 1)
                    .append(" has ")
                    .append(teams.get(i).getTeamSize())
                    .append(" players (");

            for (Person person : teams.get(i).getPersonList()) {
                sb.append(person.getName())
                        .append(",");
            }

            sb.append("). Average rate: ")
                    .append(teams.get(i).getAverageRating())
                    .append("\n");
        }
        sb.append("Teams rate standard deviation: ")
                .append(standardDeviation);

        return sb.toString();

    }
}
