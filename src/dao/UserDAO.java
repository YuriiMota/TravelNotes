package dao;

import entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();

    User getById(int id);

    int insert(User user, int accountId);

    int update(User user);

    int delete(int id);
}
