package org.example.service;

import org.example.data.GroupOfTeams;
import org.example.data.Person;
import org.example.data.Team;
import org.example.logic.InadequateNumberOfPeopleException;
import org.example.logic.StandardDeviationCalculator;
import org.example.logic.TeamsCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TeamService {
    private final TeamsCreator teamsCreator = new TeamsCreator();
    private final StandardDeviationCalculator standardDeviationCalculator = new StandardDeviationCalculator();
    public GroupOfTeams createGroupOfTeams(List<Person> personList,int numberOfTeams) throws InadequateNumberOfPeopleException {
        if(personList.size()%numberOfTeams!=0){
            throw new InadequateNumberOfPeopleException();
        }
        List<Team> teams = teamsCreator.generateTeams(personList,numberOfTeams);
        double standardDeviation = standardDeviationCalculator.calculate(teams);
        return new GroupOfTeams(teams,standardDeviation);
    }
}
