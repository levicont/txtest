package com.lvg.txtest.conv.models;

import org.joda.time.DateTime;

import java.net.URL;

/**
 * Created by Victor Levchenko (LVG Corp.) on 17.11.2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private DateTime birthDate;
    private URL personalSite;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public URL getPersonalSite() {
        return personalSite;
    }

    public void setPersonalSite(URL personalSite) {
        this.personalSite = personalSite;
    }

    @Override
    public String toString() {
        return "User - firstName: "+firstName+
                ",\n lastName: "+lastName+
                ",\n birthDate: "+birthDate+
                ",\n personalSite: "+ personalSite;
    }
}
