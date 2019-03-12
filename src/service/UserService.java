package service;

import connection.ConnectionDB;
import dao.UserDAO;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDAO {
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                User user = new User(id, firstname, lastname);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user =null;
        try(Connection connection = ConnectionDB.getConnection()){
            String sql="SELECT * FROM users WHERE id=?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int userId = resultSet.getInt(1);
                    String firstname = resultSet.getString(2);
                    String lastname = resultSet.getString(3);
                    user=new User(userId,firstname,lastname);
                }
            }
        }catch (SQLException ex){
            ex.getStackTrace();
        }
        return user;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
