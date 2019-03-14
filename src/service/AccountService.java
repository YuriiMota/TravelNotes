package service;

import com.mysql.cj.xdevapi.SqlDataResult;
import connection.ConnectionDB;
import dao.AccountDAO;
import entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements AccountDAO {
    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                Account account = new Account(id, email, password);
                accounts.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getById(int id) {
        Account account = null;
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM accounts WHERE id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int accountId = resultSet.getInt(1);
                    String email = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    account = new Account(accountId, email, password);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return account;
    }


    @Override
    public int insert(Account account) {

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "INSERT INTO accounts (email, password) Values (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, account.getEmail());
                preparedStatement.setString(2, account.getPassword());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Account account) {

        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "UPDATE accounts SET email = ?, password = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, account.getEmail());
                preparedStatement.setString(2, account.getPassword());
                preparedStatement.setInt(3, account.getId());

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
            String sql = "DELETE FROM accounts WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Account getByLogin(String login) {
        Account account = null;
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM accounts WHERE email=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int accountId = resultSet.getInt(1);
                    String email = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    account = new Account(accountId, email, password);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return account;
    }
    @Override
    public Account getByLogin(String login, String pass) {
        Account account = null;
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "SELECT * FROM accounts WHERE email=? AND password=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, pass);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int accountId = resultSet.getInt(1);
                    String email = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    account = new Account(accountId, email, password);
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return account;
    }

}
