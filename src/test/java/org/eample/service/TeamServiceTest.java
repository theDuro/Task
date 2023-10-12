package org.eample.service;
import org.example.data.GroupOfTeams;
import org.example.data.Person;
import org.example.logic.InadequateNumberOfPeopleException;
import org.example.service.TeamService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeamServiceTest {
    private  List<Person> personList = new ArrayList<>();
    private TeamService teamService = new TeamService();
    private int numberOfTeams;

    @AfterEach
    public   void cleanList(){
        personList.clear();
    }
    @Test
    void persons_6_and_size_of_team_2_all_teams_shoud_have_2_persons_in_team(){
        personList.add(new Person("Anne", 8));
        personList.add(new Person("Bob", 10));
        personList.add(new Person("Alice", 8));
        personList.add(new Person("JSON", 5));
        personList.add(new Person("Emma", 9));
        personList.add(new Person("Boby", 5));
        int numberOfTeams =3;
        int teamSize = personList.size()/numberOfTeams;
        GroupOfTeams groupOfTeams = teamService.createGroupOfTeams(personList,numberOfTeams);
        boolean isAllTeamsHaveCorectSize = groupOfTeams.getTeams().
                stream()
                .filter(t->t.getTeamSize() == teamSize)
                .count() == numberOfTeams;
        assertTrue(isAllTeamsHaveCorectSize);
    }
    @Test
    public void incorect_number_of_persons_shoud_throw_exception(){
        personList.add(new Person("Alice", 8));
        personList.add(new Person("Bob", 5));
        numberOfTeams =4;
        assertThrows(InadequateNumberOfPeopleException.class,()-> teamService.createGroupOfTeams(personList,numberOfTeams));

    }
    @Test
    public void standard_deviation_shoud_be_0_if_rating_is_equal(){
        personList.add(new Person("Adam", 8));
        personList.add(new Person("Bob", 8));
        personList.add(new Person("Anna", 8));
        personList.add(new Person("Jan", 8));
        numberOfTeams =2;
        GroupOfTeams groupOfTeams = teamService.createGroupOfTeams(personList,numberOfTeams);
        int predictedStandardDeviation =0;
        boolean isStandardDeviationEquals0 = groupOfTeams.getStandardDeviation() == predictedStandardDeviation;
        assertTrue(isStandardDeviationEquals0);
    }
    
}
