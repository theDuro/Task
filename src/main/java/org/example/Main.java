package org.example;

import org.example.data.GroupOfTeams;
import org.example.data.Person;
import org.example.data.Team;
import org.example.logic.InadequateNumberOfPeopleException;
import org.example.service.TeamService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeamService teamService = new TeamService();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 8));
        personList.add(new Person("Bob", 5));
        personList.add(new Person("Charlie", 3));
        personList.add(new Person("David", 5));
        personList.add(new Person("Eve", 9));
        personList.add(new Person("Frank", 6));
        try {
            GroupOfTeams groupOfTeams = teamService.createGroupOfTeams(personList, 3);
            System.out.println(groupOfTeams.toString());
        }catch (InadequateNumberOfPeopleException e){
            System.out.println(e.getMessage());
        }

    }
}