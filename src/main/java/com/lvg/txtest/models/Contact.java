package com.lvg.txtest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Victor on 17.11.2016.
 */
@Entity
@Table(name="contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll", query = "select c from Contact c"),
        @NamedQuery(name = "Contact.findAllCount", query = "select count(c) from Contact c")
})
public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Contact id: "+id+
                ";\t First name: "+firstName+
                ";\t Last name: "+lastName+
                ";\t Birth date: "+birthDate;
    }
}
