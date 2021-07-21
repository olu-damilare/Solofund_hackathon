package com.solofund.models;


import com.solofund.exceptions.UserValidationException;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
public class User {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String ssn;
    private String firstName;
    private String lastName;

    public String getSsn() {
        return ssn;
    }

    public User(String ssn, String firstName, String lastName) throws UserValidationException {
        validateSSN(ssn);
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSsn(String ssn) throws UserValidationException {
        validateSSN(ssn);
        this.ssn = ssn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private void validateSSN(String ssn) throws UserValidationException {
        if(ssn.length() != 9) throw new UserValidationException("Invalid input. SSN must be 9-digit numbers");
        for (int i = 0; i < ssn.length(); i++) {
            if(!Character.isDigit(ssn.charAt(i)))    {
                throw new UserValidationException("Invalid input. SSN must contain only numbers");
            }
        }


    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
