package de.jonashackt.springbootvuejs.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PAINTERS")
public class Painter {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfDeath;
    private String nationality;
    private String artPeriod;
    private String iconPath;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "PAINTER_ART", joinColumns = @JoinColumn(name = "painter_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "art_id", referencedColumnName = "id"))
    private Set<Art> arts = new HashSet<Art>();




    public Painter() {
    }

    public Painter(long id,String firstName,String lastName,String dateOfBirth,String dateOfDeath,String nationality,String artPeriod, String iconPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.nationality = nationality;
        this.artPeriod = artPeriod;
        this.iconPath = iconPath;
        this.id = id;
    }

    public Painter(String firstName, String lastName, String dateOfBirth, String dateOfDeath, String nationality, String artPeriod, String iconPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.nationality = nationality;
        this.artPeriod = artPeriod;
        this.iconPath = iconPath;
    }

    public Set<Art> getArts() {
        return arts;
    }

    public void setArts(Set<Art> arts) {
        this.arts = arts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getArtPeriod() {
        return artPeriod;
    }

    public void setArtPeriod(String artPeriod) {
        this.artPeriod = artPeriod;
    }
}
