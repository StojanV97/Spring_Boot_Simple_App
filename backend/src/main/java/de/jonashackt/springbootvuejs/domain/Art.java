package de.jonashackt.springbootvuejs.domain;

import javax.persistence.*;

@Entity
@Table(name = "ARTS")
public class Art {

    @Override
    public String toString() {
        return "Art{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", painterId=" + painterId +
                ", creationDate='" + creationDate + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", technique='" + technique + '\'' +
                ", description='" + description + '\'' +
                ", artPeriod='" + artPeriod + '\'' +
                ", iconPath='" + iconPath + '\'' +
                '}';
    }

    @Id
    private long id;
    private String name;
    private long painterId;
    private String creationDate;
    private String currentLocation;
    private String technique;
    private String description;
    private String artPeriod;
    private String iconPath;

    public Art() {
    }
    public Art(long id,String name,long painterId,String creationDate, String currentLocation,String technique,String description,String artPeriod,String iconPath) {
        this.id = id;
        this.painterId = painterId;
        this.creationDate = creationDate;
        this.currentLocation = currentLocation;
        this.technique = technique;
        this.description = description;
        this.artPeriod = artPeriod;
        this.iconPath = iconPath;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPainterId() {
        return painterId;
    }

    public void setPainterId(long painterId) {
        this.painterId = painterId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArtPeriod() {
        return artPeriod;
    }

    public void setArtPeriod(String artPeriod) {
        this.artPeriod = artPeriod;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
