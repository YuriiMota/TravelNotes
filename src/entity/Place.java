package entity;

import java.util.Objects;

public class Place {
    private int id;
    private String title;
    private String country;
    private String description;
    private String image;

    public Place() {
    }

    public Place(String title, String country, String description, String image) {
        this.title = title;
        this.country = country;
        this.description = description;
        this.image = image;
    }

    public Place(int id, String title, String country, String description, String image) {
        this.id = id;
        this.title = title;
        this.country = country;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id &&
                Objects.equals(title, place.title) &&
                Objects.equals(country, place.country) &&
                Objects.equals(description, place.description) &&
                Objects.equals(image, place.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, country, description, image);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
