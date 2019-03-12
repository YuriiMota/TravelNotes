package dao;

import entity.Place;

import java.util.List;

public interface PlaceDAO {
    List<Place> getAll();

    Place getById(int id);

    int insert(Place place);

    int update(Place place);

    int delete(int id);
}
