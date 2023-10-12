package org.example.logic;

public class InadequateNumberOfPeopleException extends RuntimeException {
    public InadequateNumberOfPeopleException() {
        super("The number of people is inadequate for even distribution among teams.");
    }
}