package dao;

import connection.ConnectionDB;
import entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface AccountDAO {
    List<Account> getAll();

    Account getById(int id);

    int insert(Account account);

    int update(Account account);

    int delete(int id);
}
