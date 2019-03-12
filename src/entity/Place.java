package entity;

import java.util.Objects;

public class Place {
    private int id;
    private String title;
    private String country;
    private String description;

    public Place() {
    }

    public Place(int id, String title, String country, String description) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id &&
                Objects.equals(title, place.title) &&
                Objects.equals(country, place.country) &&
                Objects.equals(description, place.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, country, description);
    }

    @Override
    public String toString() {
        return "PlaceDAO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
