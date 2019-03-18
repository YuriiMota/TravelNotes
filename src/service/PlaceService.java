package service;

import connection.ConnectionDB;
import entity.Place;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.PlaceDAO;

public class PlaceService implements PlaceDAO {
    @Override
    public List<Place> getAll(int fId) {
        List<Place> places = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM places WHERE users_id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, fId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    int placeId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    String description = resultSet.getString(4);
                    String image = resultSet.getString(5);
                    Place place = new Place(placeId,title,country,description,image);
                    places.add(place);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return places;
    }

    @Override
    public Place getById(int id) {
        Place place = null;
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM places WHERE id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int placeId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String country = resultSet.getString(3);
                    String description = resultSet.getString(4);
                    String image = resultSet.getString(5);
                    place = new Place(placeId, title, country, description, image);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return place;
    }

    @Override
    public int insert(Place place, int id) {

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "INSERT INTO places (title, country, description, image, users_id) Values (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, place.getTitle());
                preparedStatement.setString(2, place.getCountry());
                preparedStatement.setString(3, place.getDescription());
                if(place.getImage().isEmpty()){
                    place.setImage("resources/image/no-photo-available.jpg");
                }
                preparedStatement.setString(4, place.getImage());
                preparedStatement.setInt(5, id);
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Place place) {

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "UPDATE places SET title = ?, country = ?, description = ?, image = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, place.getTitle());
                preparedStatement.setString(2, place.getCountry());
                preparedStatement.setString(3, place.getDescription());
                preparedStatement.setString(4, place.getImage());
                preparedStatement.setInt(5, place.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "DELETE FROM places WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

/*    public static void main(String[] args) {
        List<Place>places = new ArrayList<>();
        PlaceService placeService = new PlaceService();
        places =placeService.getAll(1);
        for (Place pl:places) {
            pl.getDescription().substring(2);
        }

    }*/


}
