package org.example.logic;

import org.example.data.Person;
import org.example.data.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeamsCreator {

    public List<Team> generateTeams(List<Person> personList,int numberOfTeams) {
        int maxPeoplePerTeam = personList.size()/numberOfTeams;
        List<Team> teams = Stream.generate(Team::new)
                .limit(numberOfTeams)
                .toList();

        List<Person> sortedPeople = personList.stream()
                .sorted(Comparator.comparingInt(Person::getRate).reversed())
                .toList();

        sortedPeople.forEach(person -> {
            Team teamWithMinAvgRating = teams.stream()
                    .filter(team -> team.getTeamSize() < maxPeoplePerTeam)
                    .min(Comparator.comparingDouble(Team::calculateAvernageRating))
                    .orElseThrow(IllegalStateException::new);
            teamWithMinAvgRating.addToTeam(person);
        });
       return teams;
    }

}
