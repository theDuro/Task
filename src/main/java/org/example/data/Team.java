package org.example.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Team {
    private List<Person> personList = new ArrayList<>();
    private double averageRating;
    public Team(){
    }
    public int getTeamSize(){
        return personList.size();
    }
    public void addToTeam(Person person){
        personList.add(person);
        averageRating = calculateAvernageRating();
    }
    public double calculateAvernageRating(){
        return personList.stream()
                .mapToInt(Person::getRate)
                .average()
                .orElse(0.0);
    }
    public void sortPersonsByRating(){
        personList  = personList.stream()
                .sorted(Comparator.comparingInt(Person::getRate))
                .toList();
    }

}
